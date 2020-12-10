// =============================================================================
//                            AngularJS Project Build Script
// =============================================================================
module.exports = function (grunt) {

    //statistic for TASK execution
    require('time-grunt')(grunt);

    // global variable
    var options = {
        appName: 'MyApp',
        source: 'app/codebase',
        libraries: 'bower_components',
        target: 'dist',
        css: 'app/styles'
    };

    // TASK configuration
    grunt.initConfig({

        // load npm configuration
        pkg: grunt.file.readJSON('package.json'),

        // option object to config variable
        config: options,

        eslint: {
            options: {
                configFile: '.eslintrc.json',
                failOnError: false,
                format: 'node_modules/eslint-json/',
                outputFile: '<%= config.target %>/esLint-report.json'
            },
            target: ['<%= config.source %>/**/*.js']
        },

        clean: ['<%= config.target %>'],

        copy: {
            main: {
                files: [
                    {expand: true, flatten: true, filter: 'isFile',
                        src: ['app/index.html'],
                        dest: '<%= config.target %>/'}
                ]
            },
            templates: {
                files: [
                    {expand: true, src: ['<%= config.source %>/**/*.html'], dest: '<%= config.target %>/templates'}
                ]
            }
        },

        // relpace google references
        cdnify: {
            dist: {
                html: ['<%= config.target %>/templates/**/*.html']
            }
        },

        //html minify
        htmlmin: {
            dist: {
                options: {
                    removeCommentsFromCDATA: true,
                    collapseWhitespace: true,
                    conservativeCollapse: true,
                    clloapseBooleanAttributes: true
                },
                files: [{
                        expand: true,
                        cwd: '<%= config.target %>',
                        src: ['templates/**/*.html', '*.html'],
                        dest: '<%= config.target %>'
                    }]
            }
        },

        //compile HTML templates
        ngtemplates: {
            options: {
                url: function (url) {
                    return url.replace('dist/templates/', '');
                }
            },
            app: {
                src: '<%= config.target %>/templates/**/*.html',
                dest: '<%= config.target %>/codebase/templates.js'
            }
        },

        cssmin: {
            options: {
                mergeIntoShorthands: false,
                roundingPrecision: -1
            },
            target: {
                files: {
                    '<%= config.target %>/styles/all.min.css': ['<%= config.css %>/**/*.css']
                }
            }
        },

        // modify index.html
        useminPrepare: {
            html: 'ndex.html',
            options: {
                dest: '<%= config.target %>'
            }
        },
        usemin: {
            html: ['<%= config.target %>/*.html']
        },

        uglify: {
            options: {
                compress: {
                    dead_code: true,
                    global_defs: {
                        'DEBUG': false,
                        'PRODUCTION': true
                    },
                    output: {
                        ast: true,
                        code: true  // optional - faster if false
                    }
                }
            },
            vendor: {
                options: {
                    sourceMap: true,
                    sourceMapName: '<%= config.target %>/vendor.map.js'
                },
                files: [{
                        dest: '<%= config.target %>/scripts/vendor.js',
                        src: '<%= config.libraries %>/**/*.js'
                    }]
            },
            application: {
                options: {
                    sourceMap: {
                        includeSources: true
                    },
                    sourceMapIn: '<%= config.target %>/vendor.map.js'
                },
                files: [{
                        dest: '<%= config.target %>/scripts/application.js',
                        src: '<%= config.source %>/**/*.js'
                    }]

            }
        }
    });

    // [LOAD TASKS] ############################################################
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-google-cdn');
    grunt.loadNpmTasks('grunt-contrib-htmlmin');
    grunt.loadNpmTasks('grunt-angular-templates');
    grunt.loadNpmTasks('grunt-usemin');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-eslint');

    // [REGISTERD TASKS] #######################################################
    // beware changeing the order of the tasks / targets
    grunt.registerTask('c:message',
            function () {
                grunt.log.writeln('Build is inictiated.');
            }
    );

    grunt.registerTask('default', [
        'c:message',
        'clean',
        'c:process-templates',
        'copy:main',
        'c:css-processing']);

    grunt.registerTask('c:uglification', [
        'useminPrepare',
        'uglify:vendor',
        'uglify:application',
        'usemin']);

    grunt.registerTask('c:process-templates', [
        'copy:templates',
        'cdnify',
        'htmlmin',
        'ngtemplates']);

    grunt.registerTask('c:css-processing', [
        'useminPrepare',
//        'sass',
        'cssmin',
        'usemin']);

    grunt.registerTask('c:qualityCheck', [
        'eslint']);

};
