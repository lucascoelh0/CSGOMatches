# CS GO Matches
Este aplicativo é destinado a exibição de partidas de CS:GO a partir do dia atual. Todas as informações são consultadas da API [PandaScore](https://pandascore.co/), seguindo o fuso horário local do disposito no qual o app foi instalado.

## Implementação
Foi utilizado o Model-View-ViewModel (MVVM), com apenas uma Activity, e o padrão de use cases para simplificar o view model, e criar uma ponte entre eles e o repository. 

Foram utilizadas as seguintes bibliotecas do Android Jetpack: Navigation Component e ViewModel

Foi utilizado Koin para injeção de dependência.
