# pracEntorns
El primer que vam fer va ser instalar tots el tomcat y poder aixi desplegar l'aplicació. 
Un cop varem tenir això varem adaptar els nostres **NumbersCat** y el nostre **BigNumbers** al arxiu compartit pel professor.
Amb aquesta implemntació sorgiren molts d'errors, primer de tot varem modificar el nostre *BigNumbers*.
El primer canvi va ser quitar tots els *statics* de les diferents clases y funcions i juntament fer un implement de les noves interficies, és a dir
amb l'arxiu compartit varem tenir les noves interficies anomenades "***Numbers***" i "***BigNumberOperator***", per a 
*NumbersCat* i *BigNumber* respectivament, obviament. Després el nou metode de resta de bignumbers s'anomenava subtract,
a diferencia del que teniem previament per tant varem canvar el nombre. Tant la suma com la resta retornaven BigNumbers
pero ara retornaven String, per tant varem fer una petita modificació als dos metodes i varem modificar els test
per tal de que ara cridariem al say d'aquestes noves interficies y esperariem un String de retorn.
Amb els numberscat els tests vaser una mica diferent ja que varem haver de crear un petit *setup* per tal de cridar
les funcions. Un cop varem fer tot això ja teniem el codi funcionant i passant tots els test.

Referent a les piràmedes de test trobam tant en els test de *bignumbers* i de *numberscat* que es van pujant per cifres, 
és a dir primer es treballa amb numeros d'1 xifra, després de 2, de 3, 4 ,5...
Amb això aconseguim diferenciar les diferents situacions i per tant treballar els numeros més grans amb la 
seguretat de que els numeros per devall d'aquests funcionen i en el cas de per exemple els numbers cat a l'hora de
cercar el valor de la unitat de la decima, centena, milar, etc podem confiar en el valor de les unitats dels primers tests,
és a dir, si troban un tres mil ja sabem que aquest "tres" podem accedir-lo amb la total confiança del seu funcionament individual
gracies als primers tests de la piramide. Aquest funcionament serveix igual per al nou codi ja que aquest es una 
combinació dels dos previament nombrats.

Per als **diagrames UML** varem fer dos "grups", per una banda **José i Aron** i per l'altra **Alex i Taylor**.
Els primers es varen encarrgar de crear els següents diagrames:
1. Diagram de comunicació
2. Use case
3. Seqüencia

Mentre que els segons varen fer:
1. Diagrama de fluxe
2. Diagrama de clases

Finalment ens varem disposar a crear el *pipeline* per al nostre repositori. Al principi va ser molt dificil pero 
al final aconseguirem fer que el **Sonarqube** ens analitzi el codi tras cada commit, el que després tratarem de
fer va ser el desplegament a *Tomcat* a través del mvn clean, pero aizò donava error. Primer per la versió, ja que
utilitzavem una antiga pero la varem canviar i després simplement no ho feia.