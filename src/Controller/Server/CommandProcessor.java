package Controller.Server;

/**
 *
 * @author Leonardo González G.
 */
public class CommandProcessor {

    public final String SINGLE_SPACE = " ";
    public final String DOUBLE_SPACE = "  ";
    //Protocol - Server
    private final String NO_FOUND = "0000 ";
    private final String SUBJECT_ANSWER = "0100 ";
    private final String QUESTION_FOUND = "0200 ";
    private final String ANSWER = "1000 ";

    public int coincidence(String paragraph, String... keywords) {
        int percentage = 0;
        int totalOfMatches = 0;

        paragraph = clean(paragraph);
        for (String keyword : keywords) {

            keyword = clean(keyword);
            if (paragraph.contains(keyword)) {
                totalOfMatches++;
            }
        }
        if (totalOfMatches > 0) {
            percentage = totalOfMatches * 100 / keywords.length;
        }
        return percentage;
    }

    public String clean(String aCmd) {

        aCmd = aCmd.toLowerCase().trim();
        while (aCmd.contains(DOUBLE_SPACE)) {
            System.out.println(aCmd);
            aCmd = aCmd.replaceAll(DOUBLE_SPACE, SINGLE_SPACE);
        }
        aCmd = aCmd.replaceAll("á", "a");
        aCmd = aCmd.replaceAll("é", "e");
        aCmd = aCmd.replaceAll("í", "i");
        aCmd = aCmd.replaceAll("ó", "o");
        aCmd = aCmd.replaceAll("ú", "u");

        return aCmd;
    }
//https://sites.google.com/site/portafoliouapabycarlosestevez/ramas-de-la-computacion

    public String responseCommand(String aCmd) {
        String response = "";
        if (coincidence(aCmd, "Preguntar", "Ramas de la computación") >= 90) {
            response = QUESTION_FOUND + "¿Cuales son las ramas de la computación?;"
                    + "¿Qué es la Inteligencia Artificial?;"
                    + "¿Qué es la Arquitectura de Computadoras?;"
                    + "¿Qué es el Rendimiento de computadoras?;"
                    + "¿Qué son las Redes de Computadoras?;"
                    + "¿Qué es el computo científico?;"
                    + "¿Qué es la Informática en la Salud?;"
                    + "¿Qué es Ingeniería de Software?";

            System.out.println("¿Qué puedo preguntar acerca de las ramas de la computación?");

            //https://www.spanish.cl/ciencias-naturales/sistemas-del-cuerpo-humano.htm  
        } else if (coincidence(aCmd, "Preguntar", "Sistemas del Cuerpo Humano") >= 90) {
            response = QUESTION_FOUND + "¿Cuales son los sistemas del cuerpo humano?;"
                    + "¿Cuantos sistemas tiene el cuerpo humano?;"
                    + "¿Que es el sistema circulatorio?;"
                    + "¿Que es el sistema digestivo?;"
                    + "¿Que es el sistema endocrino?;"
                    + "¿Que es el sistema inmunologico?;"
                    + "¿Que es el sistema linfatico?;"
                    + "¿Que es el sistema muscular?;"
                    + "¿Que es el sistema nervioso?;"
                    + "¿Que es el sistema oseo?;"
                    + "¿Que es el sistema reproductor?;"
                    + "¿Que es el sistema respiratorio?;"
                    + "¿Que es el sistema sistema excretor?";

            System.out.println("¿Qué puedo preguntar acerca de los sistemas del cuerpo humano?");

        } else if (coincidence(aCmd, "Sistemas cuerpo humano", "cúantos") >= 90) {
            response = ANSWER + "En total son 11 sistemas en el cuerpo humano";
            System.out.println("¿Cuántos sistemas tiene el cuerpo humano?");

        } else if (coincidence(aCmd, "que es", "Sistema circulatorio") >= 90) {
            response = ANSWER + "Es el sistema de conexiones venosas y arteriales que "
                    + "transportan la sangre a los órganos del cuerpo.";

            System.out.println("¿Que es el sistema circulatorio?");

        } else if (coincidence(aCmd, "que es", "Sistema digestivo") >= 90) {
            response = ANSWER + "Es el sistema encargado del proceso de la digestión que es la transformación y "
                    + "la absorción de los alimentos por las células del organismo. La función "
                    + "que realiza es el transporte de los alimentos, la secreción de jugos digestivos, "
                    + "la absorción de los nutrientes y la excreción.";
            System.out.println("¿Cuáles son los organos que lo conforman?");

        } else if (coincidence(aCmd, "que es", "Sistema endocrino") >= 90) {
            response = ANSWER + "(Sistema hormonal) Es el sistema que produce hormonas que son "
                    + "liberadas a la sangre y que regulan algunas de las funciones del "
                    + "cuerpo incluyendo el estado de ánimo, el crecimiento y el metabolismo.";
            System.out.println("¿Que es el sistema endocrino?");

        } else if (coincidence(aCmd, "que es", "Sistema inmunológico") >= 90) {
            response = ANSWER + "(Sistema inmunitario) Es el sistema que permite proteger contra "
                    + "enfermedades indentificando y matando células patógenas y cancerosas.";
            System.out.println("¿Que es el sistema inmunologico?");

        } else if (coincidence(aCmd, "que es", "Sistema linfático") >= 90) {
            response = ANSWER + "Es el sistema de conductos cilíndricos parecidos a los vasos "
                    + "sanguíneos que transporte un líquido transparente llamado linfa";
            System.out.println("¿Que es el sistema linfatico?");

        } else if (coincidence(aCmd, "que es", "Sistema muscular") >= 90) {
            response = ANSWER + "Es el sistema que permite que el esqueleto se mueva, se mantenga estable y dé forma al cuerpo.";
            System.out.println("¿Que es el sistema muscular?");

        } else if (coincidence(aCmd, "que es", "Sistema nervioso") >= 90) {
            response = ANSWER + "Es el sistema de conexiones nerviosas que permite transmitir "
                    + "y tener información del medio que nos rodea.";
            System.out.println("¿Que es el sistema nervioso?");

        } else if (coincidence(aCmd, "que es", "Sistema óseo") >= 90) {
            response = ANSWER + "Es el sistema de apoyo estructural y protección a los órganos internos mediante huesos.";
            System.out.println("¿Que es el sistema oseo?");

        } else if (coincidence(aCmd, "que es", "Sistema reproductor") >= 90) {
            response = ANSWER + "Es el sistema que está relacionado con la reproducción sexual.";
            System.out.println("¿Que es el sistema reproductor?");

        } else if (coincidence(aCmd, "que es", "Sistema respiratorio") >= 90) {
            response = ANSWER + "Es el sistema encargado de captar oxígeno y eliminar el dióxido "
                    + "de carbono procedente del anabolismo celular. ";
            System.out.println("¿Que es el sistema respiratorio?");

        } else if (coincidence(aCmd, "que es", "sistema excretor") >= 90) {
            response = ANSWER + "Es el sistema que tiene la función de"
                    + " expulsar los desechos que ha dejado el proceso digestivo.";
            System.out.println("¿Que es el sistema urinario?");

        } else if (coincidence(aCmd, "que es", "Inteligencia Artificial") >= 90) {
            response = ANSWER + "Esta rama de las ciencias de la computación pretende o es requerida para la síntesis de "
                    + "procesos meta-orientados tales como la resolución de problemas, toma de decisiones, "
                    + "la adaptación del medio"
                    + " ambiente, el aprendizaje y la comunicación que se encuentran en "
                    + "los seres humanos y los animales.";

            System.out.println("¿Qué es la Inteligencia Artificial?");

        } else if (coincidence(aCmd, "que es", "Arquitectura de Computadoras") >= 90) {
            response = ANSWER + "La arquitectura de computadores u organización de computadoras digitales es "
                    + "el diseño conceptual y la estructura operacional fundamental de un sistema cómputo. ";

            System.out.println("¿Qué es la Arquitectura de Computadoras?");

        } else if (coincidence(aCmd, "que es", "Rendimiento de computadoras") >= 90) {
            response = ANSWER + "Análisis de rendimiento del equipo es el estudio del trabajo que fluye a través"
                    + " de los equipos con el objetivo general de mejora de rendimiento y control "
                    + "de tiempo de respuesta, utilizando los recursos de manera eficiente,"
                    + " la eliminación de los cuellos de botella, y la predicción de "
                    + "rendimiento bajo cargas máximas previstas.";

            System.out.println("¿Qué son las Redes de Computadoras?");

        } else if (coincidence(aCmd, "que son", "Redes de Computadoras") >= 90) {
            response = ANSWER + "Esta rama de las ciencias de la computación que tiene como objetivo "
                    + "gestionar las redes entre computadoras en todo el mundo.\n"
                    + "Sistemas concurrentes, paralelos y distribuidos";

            System.out.println("¿Qué son las redes de computadoras?");

        } else if (coincidence(aCmd, "que es", "Computo científico") >= 90) {
            response = ANSWER + "La ciencia computacional (o computación científica) es el campo "
                    + "de estudio que trata con la construcción de modelos matemáticos y "
                    + "técnicas de análisis cuantitativos así como el uso de computadoras para "
                    + "analizar y resolver problemas científicos.";

            System.out.println("¿Qué es el computo científico?");

        } else if (coincidence(aCmd, "que es", "Informática en la Salud") >= 90) {
            response = ANSWER + "Informática de la Salud se ocupa de las técnicas computacionales para la "
                    + "solución de problemas en el cuidado de la salud.";

            System.out.println("¿Qué es la Informática en la Salud?");

        } else if (coincidence(aCmd, "Ramas de la computación", "Ingeniería de Software") >= 90) {
            response = ANSWER + "Ingeniería de software es el estudio del diseño, implementación y modificación "
                    + "de software con la finalidad de asegurarse de que es de alta calidad, "
                    + "asequible, fácil de mantener, y rápido de construir.";

            System.out.println("¿Cuáles son las áreas de la Ingeniería de Software?");

        } else if (coincidence(aCmd, "Ramas de la computacion", "Ciencia de la información") >= 90) {
            response = ANSWER + "El campo estudia la estructura, algoritmos, comportamiento e interacciones "
                    + "de los sistemas naturales y artificiales que guardan, procesan, "
                    + "acceden a y comunican información. También desarrolla sus propios "
                    + "fundamentos conceptuales y teóricos y emplea fundamentos desarrollados en otros campos.";

            System.out.println("¿Cuales son las areas de la ciencia de la información?");

        } else if (coincidence(aCmd, "cuales son","ramas de la computacion") >= 90) {
            response = ANSWER + "Inteligencia artificial, Arquitectura de computadoras, Análisis de rendimiento de computadoras, "
                    + "Redes de computadoras, Informática en salud, Ingeniería de software, Ciencia de la información.";

            System.out.println("¿Cuales son las ramas de la computación?");

        } else if (coincidence(aCmd,"cuales son ", "Sistemas del cuerpo humano") >= 90) {
            response = ANSWER + "Sistema circulatorio, Sistema digestivo, Sistema endocrino, Sistema inmunológico,"
                    + "Sistema linfático, Sistema muscular, Sistema nervioso,"
                    + "Sistema óseo, Sistema reproductor, Sistema respiratorio, Sistema urinario";

            System.out.println("¿Cuales son los sistemas del cuerpo humano?");

        } else if (coincidence(aCmd, "temas") >= 90) {
            response = SUBJECT_ANSWER + "Ramas de la computacion; Sistemas del cuerpo humano";
            System.out.println("¿Sobre que temas puedo preguntar?");

        } else {
            response = NO_FOUND + "¿?";
        }
        System.out.println(response);

        return response;
    }
}
