# Java Ring Buffer

Essa é uma implementação de um Ring Buffer feito em Java.

Um Ring Buffer é uma estrutura FIFO que garante uma alocação de memória constante, utilizando como base um array de
tamanho fixo

```java
private T[] example = new (T[]) Object[tamanho];
```

Arrays são estruturas de dados imutáveis e sequenciais, fazendo com que os dados fiquem contidos em um único espaço
contíguo de memória e não há risco de realocação.

A abordagem de fila convencional prevê que os dados fiquem esparsos pela memória, visto que a mesma é implementada
utilizando ponteiros (no caso do java, objetos).

Mais informações: https://www.baeldung.com/java-ring-buffer

## Orientação a Objetos

Como desafio, escolhi implementar esta estrutura usando Object Calisthenics, que são um conjunto de 9 recomendações 
feitas pelo Jeff Bay no tocante a escrever um código mais orientado a objeto.
Mais informações: https://developerhandbook.stakater.com/content/architecture/object-calisthenics.html

Essas recomendações estão de acordo com o que Bob Martin escreve em seu "Clean Code".

## Testando

```shell
mvn run test
```

## Rodando

Recomendo escrever algum código na função Main, instanciando um novo RingBuffer com o tipo que você quiser (aceita 
generics), para verificar qual o comportamento dele.
Possui os seguintes métodos:

* insertOrRewrite 
* insertWithoutRewrite
* read
* isEmpty
* isFull