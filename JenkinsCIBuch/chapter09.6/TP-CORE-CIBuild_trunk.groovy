mavenJob('TP-CORE_CIBuild_trunk') {
	
	displayName('TP-CORE CI Build (trunk)') 

    jdk('jdk11')
    
    wrappers {
        preBuildCleanup()
    }
    
    scm {
        github('ElmarDott/TP-CORE', 'master')
    }
    
    triggers {
        scm('@hourly')
    }
    
    goals('verify')

    publishers {
        mailer('config-mngt@example.com')
    }
}
