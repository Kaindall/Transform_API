<h1>Transform CNAB: Projeto de Tradução de Cnab</h1>
<hr>
<h3>Feito por: Gustavo Zanetti</h3>
<h2>Descrição do Projeto</h2>
<p>Este projeto visa ser uma implementação parcial <a href="https://github.com/Pagnet/desafio-back-end">deste desafio aqui</a> contemplando apenas a parte de transformação do arquivo, não fazendo qualquer tipo de armazenamento ou controle de histórico. Simplesmente insira o arquivo e receba a tradução dele no formato JSON</p>
<hr>
<h2>Soluções aplicadas (leia-se: Design Patterns):</h2>
<ul>
  <li><b>Singleton</b>: Internamente utilizado pelo Springboot</li>
  <li><b>MVC</b>: Abrangendo a parte de Controller e Model para a separação lógica de comunicação e modelos representacionais a serem apresentados</li>
  <li><b>Entity</b>: Para representar um registro de Transação em si</li>
  <li><b>Builder</b>: Para encapsular a lógica completa de construção de uma Transação utilizando um CNAB</li>
</ul>
<hr>
<details>
  <summary><h2>Instalação e Execução</h2></summary>
  <content>
    <ol>
      <li>Verifique se está tudo instalado:
        <ol>
          <li><b>Gradle:</b> Já está incluído no projeto, então não é necessário instalar o Gradle globalmente..
            <ul>
              <li>Para verificar o Gradle, execute o seguinte comando no terminal:
                   <code>gradle -v </code></li>
            </ul>
          </li>
          <br>
          <li><b>Git:</b> Necessário para clonar o repositório
            <ul>
              <li>Para verificar o Git, execute o seguinte comando no terminal:
                   <code>git --version</code></li>
              <li><a href="https://git-scm.com/book/pt-pt/v2/Começando-Instalar-o-Git">Guia de como instalar</a></li>
            </ul>
          </li>
        </ol>
      <br>
      <li>Clone o repositório: <code>git clone https://github.com/Kaindall/Transform_API</code></li><br>
      <li>Navegue até a pasta do projeto, faça o build e execução da aplicação: <code>./gradlew bootRun</code></li><br>
      <li>A aplicação estará disponível no localhost:8080 para consumo!</li><br>
      <li>Os testes poderão ser feitos pela Collection do Postman em JSON na raíz do projeto!</li>
    </ol>
  </content>
</details>

