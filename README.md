# projetoSolucoesWeb
Repositorio Privado para o projeto de Solucoes Web


# instruções
1- NETBEANS -> Open Project -> Pasta do projeto -> ACH_2077

2- Verificar o arquivo persistence.xml. Ele deve conter o usuário e a senha do seu mysql server

3- Importar banco de dados. Crie no workbench um schema com o nome ACH_2077. Execute no terminal, dentro da pasta onde existe o dump, o seguinte comando mysql -u root -p ACH_2077 < ach_2077.dump.sql 

4- Dê um run no netbeans. Acesse a página http://localhost:8080/ach_2077/imoveis.xhtml. Insira um novo imóvel, e veja se ele foi salvo no banco de dados

5- http://showcase.bootsfaces.net/ -> Para montar novas páginas com HTML e CSS bootstrappados

# troubleshooting
1- Problemas com bibliotecas não encontradas: A referência pode estar quebrada. Botão direito no projeto -> Libraries, deleta as libs que estão com o "x" e reimporta as libs da pasta do projeto