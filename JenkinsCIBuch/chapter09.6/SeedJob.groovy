job('InstallJobs') {

	scm {

    	git('git://github.com/my‐project.git')

    	steps {
   
      		dsl {
        		external('*.groovy')
        		removeAction('DISABLE')
      		}
    	}
    }

    triggers {
        scm('@hourly')
    }

  	listView('Projekt_I') {
		
		description('Software Projekt I')

		jobs {
			name('Job_CIBuild-master')
			name('Job_CIBuild-branch')
  		}
  
  		columns {
			status()
			weather()
			name()
			lastSuccess()
			lastFailure()
			lastDuration()
			buildButton()
		}
  	}

}