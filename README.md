# Bored API

Aplicação em Java utilizando Spring Boot para consumir a Bored API (https://www.boredapi.com/)

# V1
Na consulta ao endpoint: https://bored-api-java.herokuapp.com/activity

É retornado uma atividade aleatoria, porém segue a regra do tipo da atividade variando conforme o horário atual:

00:00 - 05:00 : [relaxation, music, recreational

05:00 - 08:00 : [education]

08:00 - 12:00 : [busywork]

12:00 - 14:00 : [social, education, relaxation, recreational]

14:00 - 18:00 : [busywork] 

18:00 - 23:59 : [all - except busywork] 

# V2

Na consulta ao endpoint: https://bored-api-java.herokuapp.com/activities

É retornado uma lista de atividades possíveis para o seu dia, uma atividade para cada um dos intervalos listados na V1, sendo que tem que ser atividades possíveis de se fazer com dois participantes, pode-se também não ter atividade com essas caracteristicas disponíveis no intervalo de horário.


