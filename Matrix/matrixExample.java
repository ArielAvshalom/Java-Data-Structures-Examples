class main {
    public static void main(String[] args) {
      System.out.println("Hello world!");
  
      int[][] matrix = new int[3][4];
      String[][] sArray = new String[2][2];
  
      matrix[0][0] = 5;

      System.out.println(matrix[0][0]);

      System.out.println(matrix[1][1]);

      System.out.println(sArray[1][1]);

      System.out.println(matrix[0][0]);
      System.out.println(matrix[0][1]);

      for (int i = 0; i <3; i++){
          for (int j = 0; j < 4; j++){

            System.out.println(matrix[i][j]);
          }
          System.out.println("we iterated over one column");
      }
  
    }
  }