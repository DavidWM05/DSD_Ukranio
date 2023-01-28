class Main{
    public static void Generador(String[] args){                   
        System.out.println("CURP = " + getCURP());
    }
    // Función para generar una CURP aleatoria
    static String getCURP(){
        //----------|Variables Locales|----------
        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Numero = "0123456789";
        String Sexo = "HM";
        String Entidad[] = {"AS", "BC", "BS", "CC", "CS",
                            "CH", "CL", "CM", "DF", "DG",
                            "GT", "GR", "HG", "JC", "MC",
                            "MN", "MS", "NT", "NL", "OC",
                            "PL", "QT", "QR", "SP", "SL",
                            "SR", "TC", "TL", "TS", "VZ",
                            "YN", "ZS"};
        //----------|Proceso Generador|----------
        int indice;
        StringBuilder curp = new StringBuilder(18);

        for (int i = 1; i < 5; i++) {//-----Letras
            indice = (int) (Letra.length()* Math.random());
            curp.append(Letra.charAt(indice));        
        }
        for (int i = 5; i < 11; i++) {//-----Numeros
            indice = (int) (Numero.length()* Math.random());
            curp.append(Numero.charAt(indice));        
        }

        indice = (int) (Sexo.length()* Math.random());//-----Sexo
        curp.append(Sexo.charAt(indice));        
        curp.append(Entidad[(int)(Math.random()*32)]);//-----Entidad

        for (int i = 14; i < 17; i++) {//-----Letras
            indice = (int) (Letra.length()* Math.random());
            curp.append(Letra.charAt(indice));        
        }

        for (int i = 17; i < 19; i++) {//-----Numero
            indice = (int) (Numero.length()* Math.random());
            curp.append(Numero.charAt(indice));        
        }

        return curp.toString();
    }           
}