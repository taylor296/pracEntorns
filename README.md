# pracEntorns
El primer que vam fer va ser instalar tots el tomcat y poder aixi desplegar l'aplicació. 
Un cop varem tenir això varem adaptar els nostres NumbersCat y el nostre BigNumbers al arxiu compartit pel professor.
Amb aquesta implemntació sorgiren molts d'errors, primer de tot varem modificar el nostre BigNumbers.
El primer canvi va ser quitar tots els statics i juntament fer un implement de les noves interficies, és a dir
amb l'arxiu compartit varem tenir les noves interficies anomenades "Numbers" i "BigNumberOperator", per a 
NumbersCat i BigNumber respectivament, obviament. Després el nove metode de resta de bignumbers s'anomenava subtract,
a diferencia del que teniem previament per tant varem canvar el nombre. Tant la suma com la resta devolvien BigNumbers
pero ara retornaven String, per tant varem fer una petita modificacio als dos metodes i varem modificar els test
per tal de que ara cridariem al say de aquestes noves interficies y esperariem un String de retorn.
Amb els numberscat els tests vaser una mica diferent ja que varem haver de crear un petit setup per tal de cridar
les funcions. Un cop varem fer tot això ja teniem el codi funcionant i passant tots els test.