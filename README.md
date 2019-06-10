# RPGnow - Projeto Integrador 2019

#Tutorial para o desenvolvimento

#1.Instalar ambiente de desenvolvimento.
    1.1-Instalar o git (https://git-scm.com/)
    1.2-Instalar o vsCode(Editor de texto https://code.visualstudio.com/)
    1.3-Instalar o nodeJs(https://nodejs.org/en/  Ultima versão LTS)
    1.4-Instalar o docker(Vamos usar uma imagem docker do banco MONGODB, ainda será criada(https://docs.docker.com/docker-for-windows/))
    
#2.Configurando o git
    2.1-Clonar o projeto https://github.com/volponi121/projeto-integrador-2019.git 
    2.2-Depois que você clonar, você vai se locomover para a branch feature
    2.3-Realizar um git pull dentro da branch feature
    2.4-Dentro da branch feature, você cria uma nova branch a partir da mesma, 
    e para padronizar vamos utilizar o nome da nova branch de feature/numero-da-atividade(esta atividade vai ser o número que está 		 no backlog de funcionalidades, 
    ex. 011 criar uma validação de senha, ela ficaria feature/011) , no caso se estiver dentro dela é só dar um git checkout -b          		 feature/nome-da-atividade,
    ele cria uma nova branch e já faz checkout nela.
    2.5-Nosso objetivo é trabalhar em cima da feature, então todas as mudanças que você está trabalhando, você commita e da um push 		para a branch que você criou.
    2.6-Logo apos você realizar seu push, você vai criar um pull request, mas no caso seu pull request deve ser feito da branch que 		você criou para a feature, 
    no caso feature/011 -> feature.
    2.7-Caso seu pull request for aprovado, automaticamente o que você fez entra na feature.
    2.8- depois de entrar na feature, os dois administradores do projeto vão dar o pull da feature para a master, assim mantendo a 		 master funcionando.
    *2.9-*IMPORTANTE* Caso houver conflito para a feature, você deve criar uma outra branch, com a tag a mais de merge 	   			  ex(feature/011_merge) fazer um pull 
    da sua feature que deu conflito feature/011 resolver os conflitos, e fazer um pull request da feature/011_merge para a feature.
#3.Teamplate
    3.1-Vamos usar o teamplate pronto que o professor FabioRogerioSj disponibilizou para a gente usar de base.
    3.2-Por enquanto, vamos ficar só com esse teamplate.


