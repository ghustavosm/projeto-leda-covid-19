# Projeto de Laboratório de Análise de Algoritmos

## Análise comparativa de algoritmos de ordenação aplicado a dados da COVID-19

Após os estudos de análise de algoritmos de ordenação vistos em sala de aula na turma de Laboratório de Estrutura de Dados (LEDA), foi apresentado aos alunos a criação de um projeto de disciplina que visa implementar sete algoritmos (CountingSort, MergeSort, QuickSort Mediana de Três, HeapSort, QuickSort, InsertionSort, SelectionSort). O objetivo do projeto é possibilitar aos alunos a visualização prática sobre o funcionamento de cada um desses algoritmos e analisar os seus desempenhos nas situações de melhores, médios e piores casos. Para este estudo será utilizado o dataset sobre Covid-19, disponível no site [brasil.io](https://brasil.io/dataset/covid19/caso_full/), e serão aplicados os algoritmos de ordenação em dados do tipo Strings e Inteiros. Os resultados obtidos foram descritos [neste relatório](https://drive.google.com/file/d/1VFl9dGfaDglHN_VfhX5hTI35IVe0iECa/view?usp=sharing).

## Tutorial para rodar o projeto:
1.  Certifique-se de estar com uma versão do Java instalado na sua maquina com o JDK 1.8 ou superior [site oficial da Oracle.](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)

2. Clone este repositório em sua máquina [Repositório](https://github.com/ghustavosm/projeto-leda-covid-19)

3. (Opcional) Na pasta "db" perceba que existe um arquivo chamado "covid19.csv". Este arquivo é o CSV gerado a partir dos filtros aplicados no dataset do brasil.io. Você poderá baixar a versão mais recente do [dataset com filtros](https://brasil.io/dataset/covid19/caso_full/?search=&epidemiological_week=&date=&order_for_place=&state=&city=&city_ibge_code=&place_type=city&last_available_date=&is_last=True&is_repeated=False) e substituir o arquivo "db\covid19.csv" do projeto.

4. Abra o terminal e entre na pasta onde o repositório foi clonado. Execute o comando `java -jar .\ProjetoLEDACovid19.jar`.

5. (Opcional) Caso ocorra algum problema durante a execução do arquivo JAR, também será possível rodar o projeto utilizando uma IDE. Para isso, roda através da IDE o arquivo "Main.java" que está no pacore "app".

6. O código deve gerar vários arquivos CSV para melhor, pior e médio caso na subpasta "case" da pasta "db" e em "sorted" teremos os arquivos ordenados pelos algoritmos de ordenação. Cada arquivo trata-se de uma execução de um dos sete algotimos de ordenação (CountingSort, MargeSort, QuickSort Mediana de Três, HeapSort, QuickSort, InsertionSort, SelectionSort) para cada um dos três parâmetros (nome da cidade, quantidade acumulada de óbitos e quantidade acumulada de casos).