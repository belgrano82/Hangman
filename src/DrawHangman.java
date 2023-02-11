public class DrawHangman {


    String string = """
            __________                
            |    |   |
            |   ( )
            |  /[ ]\\
            |  /   \\
            |
            """;

    public void drawHangman(int mistakes) {
        switch (mistakes) {
            case 0 -> System.out.println("""
                    ___________               
                    |   \\    |
                    |  
                    |  
                    |  
                    |
                    ~~~~~~~~~~~
                    """);
            case 1 -> System.out.println("""
                    ___________               
                    |   \\    |
                    |   ()
                    |  
                    |  
                    |
                    ~~~~~~~~~~~
                    """);
            case 2 -> System.out.println("""
                    ___________                
                    |   \\    |
                    |   ()
                    |   []
                    |  
                    |
                    ~~~~~~~~~~~
                    """);
            case 3 -> System.out.println("""
                    ___________                
                    |   \\    |
                    |   ()
                    |  /[]
                    |  
                    |
                    ~~~~~~~~~~~
                    """);
            case 4 -> System.out.println("""
                    ___________                
                    |   \\    |
                    |   ()
                    |  /[]\\
                    |  
                    |
                    ~~~~~~~~~~~
                    """);
            case 5 -> System.out.println("""
                    ___________                
                    |   \\    |
                    |   ()
                    |  /[]\\
                    |  /   
                    |
                    ~~~~~~~~~~~
                    """);
            case 6 -> System.out.println("""
                    ___________                
                    |   \\    |
                    |   ()
                    |  /[]\\
                    |  /  \\
                    |
                    ~~~~~~~~~~~
                    """);
        }


    }


}

