/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JTable;

import editor.display.CharacterDisplay;

/**
 * This class represents the document being edited. Using a 2d array to hold the
 * document content is probably not a very good choice. Fixing this class is the
 * main focus of the exercise. In addition to designing a better data model, you
 * must add methods to do at least basic editing: write and delete text, and
 * moving the cursor
 *
 * @author evenal
 */
public class Document {

    private CharacterDisplay display;
    private int cursorRow;
    private int cursorCol;
  //private char[][] data;
    LinkedList<Character> data =new LinkedList<Character>();

    public Document(CharacterDisplay display) {
        this.display = display;
       //data = new char[CharacterDisplay.HEIGHT][CharacterDisplay.WIDTH];
        cursorCol = cursorRow = 0;
        display.displayCursor(' ', cursorRow, cursorCol);
        JTable table = (JTable) display.getComponent(0);
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e)  { 
           display.displayCursor(' ', table.getSelectedRow(), table.getSelectedColumn());
           setCursorPlacement(table.getSelectedRow(), table.getSelectedColumn());
            }
            });
    }

    public void insertChar(char c) {
        //data[cursorRow][cursorCol] = c;
    	data.add(c);
        display.displayChar(c, cursorRow, cursorCol);
        cursorCol++;
        if (cursorCol >= CharacterDisplay.WIDTH) {
            cursorCol = 0;
            cursorRow++;
        }
        display.displayCursor(c, cursorRow, cursorCol);
        //display.displayCursor(data[cursorRow][cursorCol],
                              //cursorRow, cursorCol);
        
    }
    public void removeChar() {
    	cursorCol--;
    	//data[cursorRow][cursorCol] = ' ';
    	data.removeLast();
    	display.displayChar(' ', cursorRow, cursorCol);
    	if(cursorCol < 0) {
    		if(cursorRow >= 1) {
    		cursorRow--;
    		}
    	}
    	display.displayCursor(' ', cursorRow, cursorCol);
    	
    }
    public void setCursorPlacement(int row, int col) {
    	cursorRow = row;
    	cursorCol = col;
    	
    }
}
