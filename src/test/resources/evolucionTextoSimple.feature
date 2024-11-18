Feature: Agregar una nueva evolucion simple con diagnostico previo
  Como medico
  Quiero agregar una nueva evolucion en la historia clinica del paciente eligiendo un diagnostico previo
  Para llevar un registro de las evoluciones que posea mi paciente

  Background:
    Given el medico "Marcelo" "Perez" que ha iniciado sesion con usuario "marcelo.perez" y password "123456"
    And ha buscado la historia clinica del paciente "25320160" que posee los siguientes diagnostivos previos:
    |Covid|
    |Gripe|
    |Dengue|

  Scenario: Nueva evolucion con texto libre
    When el medico redacta para el paciente un informe en la evolucion para el diagnostico "Dengue" eh indica en el mismo "El paciente registra una temperatura de 37º"
    And el medico guarda la evolucion
    Then se registra la evolucion en la historia clinica del paciente con el diagnostico, el informe y el medico.

  Scenario: Nueva evolucion con texto libre y pedido de laboratorio
    When el medico redacta para el paciente un informe en la evolucion para el diagnostico "Dengue" eh indica en el mismo "El paciente registra una temperatura de 37º"
    And agrega un pedido de laboratorio solicitando un "analisis de sangre" con fecha "10/05/2024" para el paciente
    And el medico guarda la evolucion
    Then se registra la evolucion en la historia clinica del paciente con el diagnostico, el informe, el pedido de laboratorio y el medico.