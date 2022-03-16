<h1 align="center">  System-Java-formatter-Json </h1>
<h3 align="center"> Criacação de um sistema onde recebe arquivo.txt e retorna os dados em formato Json.</h3>

<p align="center">
<img src="https://s3-eu-west-1.amazonaws.com/wia-flarum-bucket/2018-06-19/1529425868-938451-json.png" width="20%" height="20%"/>
</p>
<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

O programa consistem em receber um Arquivo 'txt' por args[] (parâmetro), recebendo o caminho (path do arquivo)

Exemplo: "./src/main/resources/fileData.txt"
Esse arquivo deve seguir um padrão de seus campos, e o retorno será um Json associando a um usuário para várias ordens e uma ordem para vários produtos.

O padrão do arquivo é divido no tamanho máximo de cada tabela 

```
UserID = 10   -> 0000000041
UserName = 45 -> '                           Dr. Dexter Rolfson'
OrderId = 10 -> 0000000447
ProductId = 10 -> 0000000003
ProducValue = 12 -> '     1563.47'
OrderDate = 8  - 20210630 ( formato: yyyymmdd )
```

Os id's que não tiverem todos os campos são preenchidos com 0 a esquerda e os nomes com espaço como exemplo. 

```
'0000000041                           Dr. Dexter Rolfson00000004470000000003     1563.4720210630'
```

## CI

Feito teste de Unidade com Junit para ao fazer o a Integração Continua onde ao rodar a pipeline no GitHub todos os testes devem passar para 
que não tenha problema na integração.

##CD 
Usando o Github Actions feito um script yml para fazer o deploy para o servidor, antes rodando os testes e 
tasks para garantir que tudo está correto.

