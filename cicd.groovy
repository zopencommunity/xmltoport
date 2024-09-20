node('linux')
{
   
  stage ('Poll') {
                checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        userRemoteConfigs: [[url: "https://github.com/zopencommunity/xmltoport.git"]]])
        }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/xmltoport.git'), string(name: 'PORT_DESCRIPTION', value: 'XMLTO' )]
  }
}
