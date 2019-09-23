/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuprogram;

/**
 *
 * @author dailenperez
 */
public class Sudoku {

    /** 
     constructor for Sudoku puzzle 
     * @param s String passed to constructor from main so that it makes the 
     * Sudoku puzzle.
     * @return x the array of Sudoku numbers as strings.
     **/
    public String[][] makeSudoku(String s) {
        int SIZE = 9;
        int k = 0;
        String[][] x = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                x[i][j] = s.substring(k, k + 1);
                k++;
            }
        }
        return x;
    }

    /**
     * 
     * @param x the string array containing a Sudoku puzzle
     * @return temp which contains the characters that make the puzzle look
     * like its separated into sub-squares
     */
    public String getPrintableSudoku(String[][] x) {
        int SIZE = 9;
        String temp = "";
        for (int i = 0; i < SIZE; i++) {
            if ((i == 3) || (i == 6)) {
                temp = temp + "=================\n";
            }
            for (int j = 0; j < SIZE; j++) {
                if ((j == 3) || (j == 6)) {
                    temp = temp + " || ";
                }
                temp = temp + x[i][j];
            }
            temp = temp + "\n";
        }
        return temp;
    }

    /**
     * 
     * @param x the string array containing a Sudoku puzzle
     * @return true if the Sudoku is valid and false if even one of the 
     * requirements for Sudoku isn't met.
     */
    public boolean isValidSudoku(String[][] x) {
        return rowsAreLatin(x) && colsAreLatin(x) && goodSubsquares(x);
    }
    /**
     * 
     * @param x the string array containing a Sudoku puzzle
     * @return test which is a boolean . Returns true if all rows of the Sudoku 
     * are latin and false if they aren't.
     */

    public boolean rowsAreLatin(String[][] x) {
        boolean test = true;
        for (int i = 0; i < x.length && test; i++) {
            test = test & rowIsLatin(x, i);
        }
        return test;
    }

/**
 * 
 * @param x the string array containing a Sudoku puzzle
 * @return test which is a boolean . Returns true if all columns of the Sudoku 
     * are latin and false if they aren't.
 */
    public boolean colsAreLatin(String[][] x) {
        
        boolean test = true;

        for (int j = 0; j < 9 && test; j++) {
            test = test & colIsLatin(x, j);
        }

        return test;

    }

    /**
     * 
     * @param x the string array containing a Sudoku puzzle
     * @param j the column of Sudoku puzzle that will be checked to see if its 
     * latin or not.
     * @return  boolean found , which is true if the number is unique and false if it isn't
     * as soon as any number is discovered to be a duplicate the method returns false.
     */
    public boolean colIsLatin(String[][] x, int j) {
     
        boolean puzzleNumbers[] = new boolean[9];
        boolean found = true;

        for (int i = 0; i < x[j].length && found; i++) {
            int indexNumber = Integer.parseInt(x[i][j]);

            if (puzzleNumbers[indexNumber - 1] == false) {

                puzzleNumbers[indexNumber - 1] = true;

                found = puzzleNumbers[indexNumber - 1];
            } else {
                return false;
            }
        }
        return found;
    }

    /**
     * 
     * @param x  the string array containing a Sudoku puzzle
     * @return test which is a boolean . Returns true if all subSquares of the Sudoku 
     * are latin and false if they aren't.
     */
    
    public boolean goodSubsquares(String[][] x) {
        
        boolean test = true;

        for (int i = 0; i < x.length && test; i += 3) {        

            for (int j = 0; j < 9 && test; j += 3) {          
                test = test && goodSubsquare(x, i, j);

            }
       

        }

        return test;
    }

     /**
     * 
     * @param x the string array containing a Sudoku puzzle
     * @param i the row of Sudoku puzzle that will be checked to see if its 
     * latin or not.
     * @return  boolean found , which is true if the numbers in row are unique and false if they aren't
     * and as soon as any number is discovered to be a duplicate the method returns false.
     */
     public boolean rowIsLatin(String[][] x, int i) {
        //0. Create 1-D array of boolean
        boolean puzzleNumbers[] = new boolean[9];
        boolean found = true;

        for (int j = 0; j < x.length && found; j++) {
            int indexNumber = Integer.parseInt(x[i][j]);

            if (puzzleNumbers[indexNumber - 1] == false) {

                puzzleNumbers[indexNumber - 1] = true;

                found = puzzleNumbers[indexNumber - 1];
            } else {
                return false;
            }

        }
     return found;
    }
/**
 * 
 * @param x the string array containing a Sudoku puzzle
 * @param i the row of Sudoku puzzle that will be checked to see if its 
     * latin or not.
 * @param j the column of Sudoku puzzle that will be checked to see if its 
     * latin or not.
 * @return boolean isLatin will return true if the subSquare is Latin and false if it isn't .
 */
    public boolean goodSubsquare(String[][] x, int i, int j) {
        // fill in your code here
        boolean puzzleNumbers[] = new boolean[9];
        boolean goodSquare = true;
        
        
       // boolean isLatin = true;

        for (int r = i; r < i + 3 && goodSquare ; r++) {

           for (int c = j; c < j+ 3 && goodSquare; c++) {
                 //  is row latin and column latin logic
                int indexNumber = Integer.parseInt(x[r][c]);

            if (puzzleNumbers[indexNumber - 1] == false) {

                puzzleNumbers[indexNumber - 1] = true;

                goodSquare = puzzleNumbers[indexNumber - 1];
            } else {
                return false;
            }
               
            }

        }

        return goodSquare;
    }

}

