def build(Map params){
    sh "sudo docker build -f ${params.DockerfilePath} -t ${params.DockerImage} ${params.DockerContext}"
}

def push(Map params){
    sh "sudo docker push ${params.DockerImage}"
}

def remove(Map params){
    sh "sudo docker rmi ${params.DockerImage}"
}

def promoter(Map params){
    sh "sudo docker pull ${params.DockerImage}"
    sh "sudo docker tag ${params.DockerImage} ${params.DockerNewImage}"
    sh "sudo docker push ${params.DockerNewImage}"
}
