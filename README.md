# System-Java-formatter-Json
Criacação de um sistema onde recebe arquivo.txt
O programa foi desenvolvido para fim de teste.

Recebe um args[] (parâmetro) que é o path do arquivo exemplo: ./src/main/resources/fileData.txt
Esse arquivo deve seguir um padrão de seus campos, e o restorno será um Jsonm associando usuario a várias ordens e as Order a vários Produtos.
O padrão do arquivo é id usuário 10 numérico / nome 45 texto / id pedido 10 numérico / id produto 10 numérico / valor do produto 12 decimal
data compra 8 numérico ( formato: yyyymmdd ).

Os id's que não tiverem todos os campos são preenchidos com 0 a esquerda e os nomes com espaço como exemplo. 

'0000000041                           Dr. Dexter Rolfson00000004470000000003     1563.4720210630'

CI/CD

Feito teste de Unidade com Junit para ao fazer o a Integração Continua onde ao rodar a pipeline no GitHub todos os testes devem passar para 
que não tenha problema na integração.

CD - Usando o Heroku como exemplo, usando o Github Actions feito um script yml para fazer o deploy para o servidor, antes rodando os testes e 
tasks para garantir que tudo está correto.

