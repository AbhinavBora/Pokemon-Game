//Abhinav
//October 31, 2013 - Halloween
//Pokemon Game for Computer Science Project
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class Pokemon extends Applet implements MouseListener
{
    int screen; //Global variable to hold what screen is to be displayed
    /*
    0 = Title Screen
    1 = Instructions Screen
    2 = Level 1 Game Screen
    */

    //Screen Images
    Image StarterMap, Route1, Ownhouse, profoaktalk, momtalk, titleone, titletwo, titlethree, infnido1, tornido, empnido, Battletown, gym, center, torgym, infgym, empgym;   //Number Images for Display
    //movement images
    Image fup, fdown, fright, fleft;
    //arrays for where to move, where not to move and where an event occurs
    int st[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 11, 11, 11, 11, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 3, 3, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int r1[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 2, 2, 1, 9, 9, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 1, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 0, 0, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 2, 0, 0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 0, 0, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0}, {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int oh[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 12, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int bt[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 20, 0, 0, 1, 1, 1, 1, 0, 0, 0, 19, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 18, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 21, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 21, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 22, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 23, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 22, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 24, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int gm[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 29, 0, 30, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 27, 1, 1, 1, 32, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 31, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 33, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 37, 1, 1, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 36, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 38, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 39, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 41, 0, 0, 0, 0, 0, 42, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 44, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int pc[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 52, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 53, 53, 53, 53, 53, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int xx = 16; //column # on array for startermap
    int yy = 9; //row # on array for starter map
    int dir = 1; //which direction user is facing or chose to move in
    int pok = 0; //if the user has any pokemon, if so which pokemon; 1=torterra, 2=infernape, 3=empoleon
    int trbadges = 0; //# of badges to see if they qualify to verse gym leader - going to be inserted later
    int gymbadges = 0; //# of badges to see if they qualify to verse Pokemon Champion (in final version of game - later, right now they can only verse one gym leader)
    int hp = 300; //user's pokemon's hp
    int ophp = 300; //wild pokemon's hp
    public void init ()
    {
	resize (740, 640);
	screen = -1; //start on screen 0, the Title Screen
	addMouseListener (this);
	Graphics g = getGraphics ();

	titleone = getImage (getDocumentBase (), "titleframe1.jpg"); //frame one of title screen
	g.drawImage (titleone, -100, -100, this);

	titletwo = getImage (getDocumentBase (), "titleframe2.jpg"); //frame two of title screen
	g.drawImage (titletwo, -100, -100, this);

	titlethree = getImage (getDocumentBase (), "titleframe3.jpg"); //frame three of title screen
	g.drawImage (titlethree, -100, -100, this);

	StarterMap = getImage (getDocumentBase (), "startermap.jpg");
	g.drawImage (StarterMap, -100, -100, this);

	Route1 = getImage (getDocumentBase (), "route1.jpg");
	g.drawImage (Route1, -100, -100, this);

	Battletown = getImage (getDocumentBase (), "battletown.jpg");
	g.drawImage (Battletown, -100, -100, this);

	gym = getImage (getDocumentBase (), "gym.jpg");
	g.drawImage (gym, -100, -100, this);

	torgym = getImage (getDocumentBase (), "battletorgym.jpg"); //Torterra fighting gym leader
	g.drawImage (torgym, -100, -100, this);

	infgym = getImage (getDocumentBase (), "battleinfgym.jpg"); //Infernape fighting gym leader
	g.drawImage (infgym, -100, -100, this);

	empgym = getImage (getDocumentBase (), "battleempgym.jpg"); //Empoleon fighting gym leader
	g.drawImage (Route1, -100, -100, this);

	center = getImage (getDocumentBase (), "center.jpg"); //pokemon center to heal
	g.drawImage (Route1, -100, -100, this);

	infnido1 = getImage (getDocumentBase (), "battleinfnido.jpg"); //Infernape fighting wild pokemon(Nidoking - nido)
	g.drawImage (infnido1, -100, -100, this);

	tornido = getImage (getDocumentBase (), "battletornido.jpg"); //Torterra fighting wild pokemon
	g.drawImage (tornido, -100, -100, this);

	empnido = getImage (getDocumentBase (), "battleempnido.jpg"); //Empoleon fighting wild pokemon
	g.drawImage (empnido, -100, -100, this);

	Ownhouse = getImage (getDocumentBase (), "possiblehouse.jpg");
	g.drawImage (Ownhouse, -100, -100, this);

	profoaktalk = getImage (getDocumentBase (), "profoaktalk.jpg"); //talking to professor - displays talk button
	g.drawImage (Ownhouse, -100, -100, this);

	momtalk = getImage (getDocumentBase (), "profoaktalk.jpg"); //displays talk button, same as talking to professor, so don't need another image
	g.drawImage (momtalk, -100, -100, this);

	fup = getImage (getDocumentBase (), "Facinguptrainer.gif");
	g.drawImage (fup, -100, -100, this);

	fdown = getImage (getDocumentBase (), "facingdowntrainer.gif");
	g.drawImage (fdown, -100, -100, this);

	fright = getImage (getDocumentBase (), "facingrighttrainer.gif");
	g.drawImage (fright, -100, -100, this);

	fleft = getImage (getDocumentBase (), "facinglefttrainer.gif");
	g.drawImage (fleft, -100, -100, this);


    }


    public void mouseClicked (MouseEvent e)
    {
    }


    public void mouseEntered (MouseEvent e)
    {
    }


    public void mouseExited (MouseEvent e)
    {
    }


    public void mouseReleased (MouseEvent e)
    {
    }


    //to talk to prof (to pick pokemon) and to mom

    public void talk (int x, int y)
    {
	if (screen == 3 && x > 646 && x < 731 && y > 511 && y < 546) //when screen = 3 - profoaktalk - and they clicked on talk button
	{
	    //Show a dialog asking the user to select a pokemon:
	    String[] possibleValues = {"Torterra - Grass Type", "Infernape - Fire Type", "Empoleon - Water Type"};
	    String selectedValue = (String) JOptionPane.showInputDialog (null, "Welcome to the world of Pokemon\n\n"
		    + "It is filled with many perils and adventure.\n"
		    + "Lets begin your journey.\n"
		    + "You're in luck. I've found some rare pokemon\n"
		    + "Feel free to pick a pokemon.",
		    "Professor Rowan", JOptionPane.INFORMATION_MESSAGE, null,
		    possibleValues, possibleValues [0]);
	    if (selectedValue.equals ("Torterra - Grass Type"))
		pok = 1; //1=torterra
	    else if (selectedValue.equals ("Infernape - Fire Type"))
		pok = 2; //2=infernape
	    else
		pok = 3; //3 = empoleon

	    JOptionPane.showMessageDialog (null, selectedValue + "\nGreat Choice\n" +
		    "I wish you well on your journey", "Professor Rowan",
		    JOptionPane.INFORMATION_MESSAGE);
	}
	else if (screen == 4 && x > 646 && x < 731 && y > 511 && y < 546) //when screen = 4 - momtalk - and they clicked on talk button
	{
	    if (pok > 0) //if user has pokemon
	    {
		if (hp == 300) //if user's pokemon is at full health
		{
		    JOptionPane.showMessageDialog (null, "Good Luck in the world of Pokemon.\n" + "Make sure to treat your pokemon with respect.\n" +
			    "Visit the Pokemon Center to Heal your Pokemon.", "Mom",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else if (hp < 300) // if user's pokemon's health is low then heals
		{
		    JOptionPane.showMessageDialog (null, "There I've healed your Pokemon.\n" + "Make sure to treat your pokemon with respect.\n" +
			    "Visit the Pokemon Center to Heal your Pokemon in a city.", "Mom",
			    JOptionPane.INFORMATION_MESSAGE);
		    hp = 300; //restores hp
		}
	    }
	    else if (pok == 0) //if user doesn't have pokemon
	    {
		JOptionPane.showMessageDialog (null, "Lets begin your journey into the world of Pokemon\n" + "Talk to Professor Rowan to begin.\n" +
			"Good Luck on your journey", "Mom",
			JOptionPane.INFORMATION_MESSAGE);
	    }
	}
    }


    public void wild ()  //if they are on wild grass this method is called
    {
	int w = (int) (Math.random () * 5) + 1; //a chance of getting into a battle
	//if w = 1, then you get into a battle depending on which pokemon you chose , 1, 2, or 3 (look above)
	if (w == 1 && pok == 2)
	    screen = 5;
	else if (w == 1 && pok == 1)
	    screen = 6;
	else if (w == 1 && pok == 3)
	    screen = 7;
    }


    public void gymbattle ()  //if they are going to battle the gym leader this method is called
    {
	//different battle screens for their different choices
	if (pok == 2)
	    screen = 12;
	else if (pok == 1)
	    screen = 11;
	else if (pok == 3)
	    screen = 13;
    }


    public void movedpad (int x, int y, int a[] [])  //takes in mouse clicked co-ordinates and the corresponding array for the screeen
    {
	if (x > 674 && x < 700 && y > 15 && y < 37) //up
	{
	    dir = 1;
	    yy--;
	    //tried to put all these options as a method but didn't work out - computer didn't accept different arrays, so here they are
	    if (a [yy] [xx] == 11 && pok > 0) //to go to route 1 if you've picked a pokemon already
	    {
		screen = 1;
		xx = 17;
		yy = 31;
	    }
	    else if (a [yy] [xx] == 11 && pok == 0) //if you haven't picked a pokemon and you try to go to route1
	    {
		JOptionPane.showMessageDialog (null, "You cannot travel to Route 1 without a Pokemon", "No Pokemon",
			JOptionPane.ERROR_MESSAGE);
		yy++; //these are to go back to the original position after you've moved
	    }
	    else if (a [yy] [xx] == 2) //wild grass
	    {
		wild ();

	    }
	    else if (a [yy] [xx] == 5) //rival house
	    {
		JOptionPane.showMessageDialog (null, "Nobody is in the house.\n" + "Your rival Barry has already left for Veilstone City - First Gym.", "Cannot Enter",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 6) //going to battle town
	    {
		String input = JOptionPane.showInputDialog ("Please enter the password ");
		if (input.equalsIgnoreCase ("Battle")) //correct password
		{
		    JOptionPane.showMessageDialog (null, "Correct Password", "Password",
			    JOptionPane.INFORMATION_MESSAGE);
		    screen = 8;
		    xx = 31;
		    yy = 17;
		}
		else //incorrect password
		{
		    JOptionPane.showMessageDialog (null, "WRONG PASSWORD\nCannot proceed to Battle Town,", "Password",
			    JOptionPane.ERROR_MESSAGE);
		    yy++;
		}
	    }
	    else if (a [yy] [xx] == 7) //back to starter town
	    {
		screen = 0;
		xx = 16;
		yy = 0;
	    }
	    else if (a [yy] [xx] == 9) //sign
	    {
		JOptionPane.showMessageDialog (null, "Wild Pokemon\n" + "You can fight, if you win you get the password and have health restored\n" +
			"If you lose, you faint!!!", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 8) //sign
	    {
		JOptionPane.showMessageDialog (null, "How to Battle\n" + "Different moves have different damages.\nChoose the right moves and you win.\nChoose the wrong ones and you lose.\n" +
			"If you lose, you faint!!!", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 3) //sign
	    {
		JOptionPane.showMessageDialog (null, "Twinleaf Town\n" + "Make sure to treat your pokemon with respect\n" +
			"Continue on to Route 1 with your Pokemon", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 4) //own house
	    {
		screen = 2;
		xx = 27;
		yy = 26;
	    }
	    else if (a [yy] [xx] == 14) //stairs
	    {
		screen = 0;
		xx = 9;
		yy = 16;
	    }
	    else if (a [yy] [xx] == 13 && pok < 1)
		/*if they haven't selected a pokemon (pok < 1) only then go to screen 3,
		otherwise don't go so that user can't select new pokemon;
		 so after their choice they cannot pick another pokemon
		 */
		{
		    screen = 3;

		}
	    else if (a [yy] [xx - 1] == 13 || a [yy] [xx + 1] == 13 || a [yy - 1] [xx] == 13) //if you move away from the talk screen then youre -1 from that coordinate and it goes back to the normal screeen without talk button
		screen = 2;
	    else if (a [yy] [xx] == 12) //momtalk screen
	    {
		screen = 4;

	    }
	    else if (a [yy] [xx - 1] == 12 || a [yy] [xx + 1] == 12 || a [yy - 1] [xx] == 12) //if you move away from the talk screen then youre -1 from that coordinate and it goes back to the normal screeen without talk button
		screen = 2;
	    else if (a [yy] [xx] == 15) //can;t go in house
	    {
		JOptionPane.showMessageDialog (null, "WHOA THERE!\nCan't barge into someone's house.", "Locked",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 16) //pokemart
	    {
		JOptionPane.showMessageDialog (null, "NO MONEY TO BUY\nCannot go In.", "Locked",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 17) //well sign
	    {
		JOptionPane.showMessageDialog (null, "DON'T TRY JUMPING INTO THE WELL", "Sign",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 18) //well
	    {
		JOptionPane.showMessageDialog (null, "DON'T TRY JUMPING INTO A WELL", "AHHH!!",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 19) //pokemon center
	    {
		screen = 10;
		xx = 10;
		yy = 28;
	    }
	    else if (a [yy] [xx] == 20) //sign
	    {
		JOptionPane.showMessageDialog (null, "Continue onto the Elite 4 if you've beaten the Gym Leader", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 21) //can't go to road
	    {
		JOptionPane.showMessageDialog (null, "ROUTE BLOCKED\nSorry, Victory Road is Under Construction.", "BLOCKED",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 22) //back to route 1
	    {
		screen = 1;
		xx = 0;
		yy = 23;
	    }
	    else if (a [yy] [xx] == 23) //house
	    {
		JOptionPane.showMessageDialog (null, "The person will only let you in \nafter you've beaten the Elite 4.", "BLOCKED",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 24) //gym
	    {
		screen = 9;
		xx = 20;
		yy = 29;
	    }
	    else if (a [yy] [xx] == 26) //gym leader
	    {
		if (gymbadges == 0) //isn't working currently, but will work later - goes for all int gymbadges
		    gymbattle ();
		else
		{
		    JOptionPane.showMessageDialog (null, "You've already obtained the leaf badge.", "Can't battle again.",
			    JOptionPane.ERROR_MESSAGE);
		    yy++;
		}
	    }
	    else if (a [yy] [xx] == 31) //teleporter
	    {
		xx = 19;
		yy = 8;
	    }
	    else if (a [yy] [xx] == 27) //teleporter
	    {
		xx = 11;
		yy = 9;
	    }
	    else if (a [yy] [xx] == 34) //teleporter
	    {
		xx = 3;
		yy = 8;
	    }
	    else if (a [yy] [xx] == 29) //teleporter
	    {
		xx = 28;
		yy = 11;
	    }
	    else if (a [yy] [xx] == 36) //teleporter
	    {
		xx = 8;
		yy = 20;
	    }
	    else if (a [yy] [xx] == 41) //teleporter
	    {
		xx = 3;
		yy = 15;
	    }
	    else if (a [yy] [xx] == 35) //teleporter
	    {
		xx = 20;
		yy = 15;
	    }
	    else if (a [yy] [xx] == 38) //teleporter
	    {
		xx = 14;
		yy = 14;
	    }
	    else if (a [yy] [xx] == 40) //broken teleporter
	    {
		JOptionPane.showMessageDialog (null, "Teleporter not working.", "BROKEN",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 43) //teleporter
	    {
		xx = 20;
		yy = 26;
	    }
	    else if (a [yy] [xx] == 44) //teleporter
	    {
		xx = 12;
		yy = 23;
	    }
	    else if (a [yy] [xx] == 46) // back to battle town
	    {
		screen = 8;
		xx = 8;
		yy = 20;
	    }
	    else if (a [yy] [xx] == 45) //help guy in gym
	    {
		if (gymbadges == 0)
		{
		    JOptionPane.showMessageDialog (null, "Welcome to the Gym.\nAs you can see this gym is a maze of teleporters.\nBut they're pretty straightforward.", "Help Guy",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "CONGRATULATIONS.", "Help Guy",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		yy++;
	    }
	    else if (a [yy] [xx] == 30 || a [yy] [xx] == 32 || a [yy] [xx] == 33 || a [yy] [xx] == 37 || a [yy] [xx] == 39 || a [yy] [xx] == 42) //trainers wishing good luck in gym
	    {
		if (gymbadges == 0)
		{
		    JOptionPane.showMessageDialog (null, "Good Luck with the Gym Leader", "Advice",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "CONGRATULATIONS.", "Advice",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		yy++;
	    }
	    else if (a [yy] [xx] == 50) //blue haired girl blocking way in pokemon center
	    {
		JOptionPane.showMessageDialog (null, "CANNOT ENTER", "NO ENTRY",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 51) //heal pokemon if you choose to heal
	    {
		String[] possibleValues = {"Heal.", "No Thanks."};
		String selectedValue = (String) JOptionPane.showInputDialog (null, "We can heal your Pokemon.",
			"Heal", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		if (selectedValue.equals ("Heal."))
		{
		    hp = 300; //restores hp
		    JOptionPane.showMessageDialog (null, "We have healed your Pokemon.\nGoodbye.", "Heal Pokemon",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "Goodbye.", "Heal Pokemon",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		yy++;
	    }
	    else if (a [yy] [xx] == 52) //blocked way
	    {
		JOptionPane.showMessageDialog (null, "CANNOT ENTER", "NO ENTRY",
			JOptionPane.ERROR_MESSAGE);
		yy++;
	    }
	    else if (a [yy] [xx] == 53) //leave pokemon center
	    {
		screen = 8;
		xx = 12;
		yy = 12;
	    }
	    else if (a [yy] [xx] == 0) //if you go on something you can't go on
		yy++;

	}
	//same options as up, except some changes because you are moving down so its yy-- to move back to your original position after the event/place you can't go to
	else if (x > 678 && x < 701 && y > 69 && y < 88) //down
	{
	    dir = 2;
	    yy++;
	    if (a [yy] [xx] == 11 && pok > 0)
	    {
		screen = 1;
		xx = 17;
		yy = 31;
	    }
	    else if (a [yy] [xx] == 11 && pok == 0)
	    {
		JOptionPane.showMessageDialog (null, "You cannot travel to Route 1 without a Pokemon", "No Pokemon",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 2)
		wild ();
	    else if (a [yy] [xx] == 5)
	    {
		JOptionPane.showMessageDialog (null, "Nobody is in the house.\n" + "Your rival Barry has already left for Veilstone City - First Gym.", "Cannot Enter",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 6)
	    {
		String input = JOptionPane.showInputDialog ("Please enter the password ");
		if (input.equalsIgnoreCase ("Battle"))
		{
		    JOptionPane.showMessageDialog (null, "Correct Password", "Password",
			    JOptionPane.INFORMATION_MESSAGE);
		    screen = 8;
		    xx = 31;
		    yy = 17;
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "WRONG PASSWORD\nCannot proceed to Battle Town,", "Password",
			    JOptionPane.ERROR_MESSAGE);
		    yy--;
		}
	    }
	    else if (a [yy] [xx] == 7)
	    {
		screen = 0;
		xx = 16;
		yy = 0;
	    }
	    else if (a [yy] [xx] == 9)
	    {
		JOptionPane.showMessageDialog (null, "Wild Pokemon\n" + "You can fight, if you win you get the password and have health restored\n" +
			"If you lose, you faint!!!", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 8)
	    {
		JOptionPane.showMessageDialog (null, "How to Battle\n" + "Different moves have different damages.\nChoose the right moves and you win.\nChoose the wrong ones and you lose.\n" +
			"If you lose, you faint!!!", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 3)
	    {
		JOptionPane.showMessageDialog (null, "Twinleaf Town\n" + "Make sure to treat your pokemon with respect\n" +
			"Continue on to Route 1 with your Pokemon", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 4)
	    {
		screen = 2;
		xx = 27;
		yy = 26;
	    }
	    else if (a [yy] [xx] == 14)
	    {
		screen = 0;
		xx = 9;
		yy = 16;
	    }
	    else if (a [yy] [xx] == 13 && pok < 1)
		/*if they haven't selected a pokemon (pok < 1) only then go to screen 3,
		otherwise don't go so that user can't select new pokemon;
		 so after their choice they cannot pick another pokemon
		 */
		{
		    screen = 3;

		}
	    else if (a [yy] [xx - 1] == 13 || a [yy] [xx + 1] == 13 || a [yy - 1] [xx] == 13)
		screen = 2;
	    else if (a [yy] [xx] == 12)
	    {
		screen = 4;

	    }
	    else if (a [yy] [xx - 1] == 12 || a [yy] [xx + 1] == 12 || a [yy - 1] [xx] == 12)
		screen = 2;
	    else if (a [yy] [xx] == 15)
	    {
		JOptionPane.showMessageDialog (null, "WHOA THERE!\nCan't barge into someone's house.", "Locked",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 16)
	    {
		JOptionPane.showMessageDialog (null, "NO MONEY TO BUY\nCannot go In.", "Locked",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 17)
	    {
		JOptionPane.showMessageDialog (null, "DON'T TRY JUMPING INTO THE WELL", "Sign",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 18)
	    {
		JOptionPane.showMessageDialog (null, "DON'T TRY JUMPING INTO A WELL", "AHHH!!!",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 19)
	    {
		screen = 10;
		xx = 10;
		yy = 28;
	    }
	    else if (a [yy] [xx] == 20)
	    {
		JOptionPane.showMessageDialog (null, "Continue onto the Elite 4 if you've beaten the Gym Leader", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 21)
	    {
		JOptionPane.showMessageDialog (null, "ROUTE BLOCKED\nSorry, Victory Road is Under Construction.", "BLOCKED",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 22)
	    {
		screen = 1;
		xx = 0;
		yy = 23;
	    }
	    else if (a [yy] [xx] == 23)
	    {
		JOptionPane.showMessageDialog (null, "The person will only let you in \nafter you've beaten the Elite 4.", "BLOCKED",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 24)
	    {
		screen = 9;
		xx = 20;
		yy = 29;
	    }
	    else if (a [yy] [xx] == 26)
	    {
		if (gymbadges == 0)
		    gymbattle ();
		else
		{
		    JOptionPane.showMessageDialog (null, "You've already obtained the leaf badge.", "Can't battle again.",
			    JOptionPane.ERROR_MESSAGE);
		    yy--;
		}
	    }
	    else if (a [yy] [xx] == 31)
	    {
		xx = 19;
		yy = 8;
	    }
	    else if (a [yy] [xx] == 27)
	    {
		xx = 11;
		yy = 9;
	    }
	    else if (a [yy] [xx] == 34)
	    {
		xx = 3;
		yy = 8;
	    }
	    else if (a [yy] [xx] == 29)
	    {
		xx = 28;
		yy = 11;
	    }
	    else if (a [yy] [xx] == 36)
	    {
		xx = 8;
		yy = 20;
	    }
	    else if (a [yy] [xx] == 41)
	    {
		xx = 3;
		yy = 15;
	    }
	    else if (a [yy] [xx] == 35)
	    {
		xx = 20;
		yy = 15;
	    }
	    else if (a [yy] [xx] == 38)
	    {
		xx = 14;
		yy = 14;
	    }
	    else if (a [yy] [xx] == 40)
	    {
		JOptionPane.showMessageDialog (null, "Teleporter not working.", "BROKEN",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 43)
	    {
		xx = 20;
		yy = 26;
	    }
	    else if (a [yy] [xx] == 44)
	    {
		xx = 12;
		yy = 23;
	    }
	    else if (a [yy] [xx] == 46)
	    {
		screen = 8;
		xx = 8;
		yy = 20;
	    }
	    else if (a [yy] [xx] == 45)
	    {
		if (gymbadges == 0)
		{
		    JOptionPane.showMessageDialog (null, "Welcome to the Gym.\nAs you can see this gym is a maze of teleporters.\nBut they're pretty straightforward.", "Help Guy",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "CONGRATULATIONS.", "Help Guy",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		yy--;
	    }
	    else if (a [yy] [xx] == 30 || a [yy] [xx] == 32 || a [yy] [xx] == 33 || a [yy] [xx] == 37 || a [yy] [xx] == 39 || a [yy] [xx] == 42)
	    {
		if (gymbadges == 0)
		{
		    JOptionPane.showMessageDialog (null, "Good Luck with the Gym Leader", "Advice",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "CONGRATULATIONS.", "Advice",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		yy--;
	    }
	    else if (a [yy] [xx] == 50)
	    {
		JOptionPane.showMessageDialog (null, "CANNOT ENTER", "NO ENTRY",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 51)
	    {
		String[] possibleValues = {"Heal.", "No Thanks."};
		String selectedValue = (String) JOptionPane.showInputDialog (null, "We can heal your Pokemon.",
			"Heal", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		if (selectedValue.equals ("Heal."))
		{
		    hp = 300;
		    JOptionPane.showMessageDialog (null, "We have healed your Pokemon.\nGoodbye.", "Heal Pokemon",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "Goodbye.", "Heal Pokemon",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		yy--;
	    }
	    else if (a [yy] [xx] == 52)
	    {
		JOptionPane.showMessageDialog (null, "CANNOT ENTER", "NO ENTRY",
			JOptionPane.ERROR_MESSAGE);
		yy--;
	    }
	    else if (a [yy] [xx] == 53)
	    {
		screen = 8;
		xx = 12;
		yy = 12;
	    }
	    else if (a [yy] [xx] == 0)
		yy--;
	}
	//same options as up, except some changes because you are moving right so its xx-- to move back to your original position after the event/place you can't go to
	else if (x > 703 && x < 728 && y > 39 && y < 62) //right
	{
	    dir = 3;
	    xx++;
	    if (a [yy] [xx] == 11 && pok > 0)
	    {
		screen = 1;
		xx = 17;
		yy = 31;
	    }
	    else if (a [yy] [xx] == 11 && pok == 0)
	    {
		JOptionPane.showMessageDialog (null, "You cannot travel to Route 1 without a Pokemon", "No Pokemon",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 2)
		wild ();
	    else if (a [yy] [xx] == 5)
	    {
		JOptionPane.showMessageDialog (null, "Nobody is in the house.\n" + "Your rival Barry has already left for Veilstone City - First Gym.", "Cannot Enter",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 6)
	    {
		String input = JOptionPane.showInputDialog ("Please enter the password ");
		if (input.equalsIgnoreCase ("Battle"))
		{
		    JOptionPane.showMessageDialog (null, "Correct Password", "Password",
			    JOptionPane.INFORMATION_MESSAGE);
		    screen = 8;
		    xx = 31;
		    yy = 17;
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "WRONG PASSWORD\nCannot proceed to Battle Town,", "Password",
			    JOptionPane.ERROR_MESSAGE);
		    xx--;
		}
	    }
	    else if (a [yy] [xx] == 7)
	    {
		screen = 0;
		xx = 16;
		yy = 0;
	    }
	    else if (a [yy] [xx] == 9)
	    {
		JOptionPane.showMessageDialog (null, "Wild Pokemon\n" + "You can fight, if you win you get the password and have health restored\n" +
			"If you lose, you faint!!!", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 8)
	    {
		JOptionPane.showMessageDialog (null, "How to Battle\n" + "Different moves have different damages.\nChoose the right moves and you win.\nChoose the wrong ones and you lose.\n" +
			"If you lose, you faint!!!", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 3)
	    {
		JOptionPane.showMessageDialog (null, "Twinleaf Town\n" + "Make sure to treat your pokemon with respect\n" +
			"Continue on to Route 1 with your Pokemon", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 4)
	    {
		screen = 2;
		xx = 27;
		yy = 26;
	    }
	    else if (a [yy] [xx] == 14)
	    {
		screen = 0;
		xx = 9;
		yy = 16;
	    }
	    else if (a [yy] [xx] == 13 && pok < 1)
		/*if they haven't selected a pokemon (pok < 1) only then go to screen 3,
		otherwise don't go so that user can't select new pokemon;
		 so after their choice they cannot pick another pokemon
		 */
		{
		    screen = 3;

		}
	    else if (a [yy] [xx - 1] == 13 || a [yy] [xx + 1] == 13 || a [yy - 1] [xx] == 13)
		screen = 2;
	    else if (a [yy] [xx] == 12)
	    {
		screen = 4;

	    }
	    else if (a [yy] [xx - 1] == 12 || a [yy] [xx + 1] == 12 || a [yy - 1] [xx] == 12)
		screen = 2;
	    else if (a [yy] [xx] == 15)
	    {
		JOptionPane.showMessageDialog (null, "WHOA THERE!\nCan't barge into someone's house.", "Locked",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 16)
	    {
		JOptionPane.showMessageDialog (null, "NO MONEY TO BUY\nCannot go In.", "Locked",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 17)
	    {
		JOptionPane.showMessageDialog (null, "DON'T TRY JUMPING INTO THE WELL", "Sign",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 18)
	    {
		JOptionPane.showMessageDialog (null, "DON'T TRY JUMPING INTO A WELL", "AHHH!!!",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 19)
	    {
		screen = 10;
		xx = 10;
		yy = 28;
	    }
	    else if (a [yy] [xx] == 20)
	    {
		JOptionPane.showMessageDialog (null, "Continue onto the Elite 4 if you've beaten the Gym Leader", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 21)
	    {
		JOptionPane.showMessageDialog (null, "ROUTE BLOCKED\nSorry, Victory Road is Under Construction.", "BLOCKED",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 22)
	    {
		screen = 1;
		xx = 0;
		yy = 23;
	    }
	    else if (a [yy] [xx] == 23)
	    {
		JOptionPane.showMessageDialog (null, "The person will only let you in \nafter you've beaten the Elite 4.", "BLOCKED",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 24)
	    {
		screen = 9;
		xx = 20;
		yy = 29;
	    }
	    else if (a [yy] [xx] == 26)
	    {
		if (gymbadges == 0)
		    gymbattle ();
		else
		{
		    JOptionPane.showMessageDialog (null, "You've already obtained the leaf badge.", "Can't battle again.",
			    JOptionPane.ERROR_MESSAGE);
		    xx--;
		}
	    }
	    else if (a [yy] [xx] == 31)
	    {
		xx = 19;
		yy = 8;
	    }
	    else if (a [yy] [xx] == 27)
	    {
		xx = 11;
		yy = 9;
	    }
	    else if (a [yy] [xx] == 34)
	    {
		xx = 3;
		yy = 8;
	    }
	    else if (a [yy] [xx] == 29)
	    {
		xx = 28;
		yy = 11;
	    }
	    else if (a [yy] [xx] == 36)
	    {
		xx = 8;
		yy = 20;
	    }
	    else if (a [yy] [xx] == 41)
	    {
		xx = 3;
		yy = 15;
	    }
	    else if (a [yy] [xx] == 35)
	    {
		xx = 20;
		yy = 15;
	    }
	    else if (a [yy] [xx] == 38)
	    {
		xx = 14;
		yy = 14;
	    }
	    else if (a [yy] [xx] == 40)
	    {
		JOptionPane.showMessageDialog (null, "Teleporter not working.", "BROKEN",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 43)
	    {
		xx = 20;
		yy = 26;
	    }
	    else if (a [yy] [xx] == 44)
	    {
		xx = 12;
		yy = 23;
	    }
	    else if (a [yy] [xx] == 46)
	    {
		screen = 8;
		xx = 8;
		yy = 20;
	    }
	    else if (a [yy] [xx] == 45)
	    {
		if (gymbadges == 0)
		{
		    JOptionPane.showMessageDialog (null, "Welcome to the Gym.\nAs you can see this gym is a maze of teleporters.\nBut they're pretty straightforward.", "Help Guy",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "CONGRATULATIONS.", "Help Guy",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		xx--;
	    }
	    else if (a [yy] [xx] == 30 || a [yy] [xx] == 32 || a [yy] [xx] == 33 || a [yy] [xx] == 37 || a [yy] [xx] == 39 || a [yy] [xx] == 42)
	    {
		if (gymbadges == 0)
		{
		    JOptionPane.showMessageDialog (null, "Good Luck with the Gym Leader", "Advice",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "CONGRATULATIONS.", "Advice",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		xx--;
	    }
	    else if (a [yy] [xx] == 50)
	    {
		JOptionPane.showMessageDialog (null, "CANNOT ENTER", "NO ENTRY",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 51)
	    {
		String[] possibleValues = {"Heal.", "No Thanks."};
		String selectedValue = (String) JOptionPane.showInputDialog (null, "We can heal your Pokemon.",
			"Heal", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		if (selectedValue.equals ("Heal."))
		{
		    hp = 300;
		    JOptionPane.showMessageDialog (null, "We have healed your Pokemon.\nGoodbye.", "Heal Pokemon",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "Goodbye.", "Heal Pokemon",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		xx--;
	    }
	    else if (a [yy] [xx] == 52)
	    {
		JOptionPane.showMessageDialog (null, "CANNOT ENTER", "NO ENTRY",
			JOptionPane.ERROR_MESSAGE);
		xx--;
	    }
	    else if (a [yy] [xx] == 53)
	    {
		screen = 8;
		xx = 12;
		yy = 12;
	    }
	    else if (a [yy] [xx] == 0)
		xx--;
	}
	//same options as up, except some changes because you are moving left so its xx++ to move back to your original position after the event/place you can't go to
	else if (x > 649 && x < 674 && y > 41 && y < 65) //left
	{
	    dir = 4;
	    xx--;
	    if (a [yy] [xx] == 11 && pok > 0)
	    {
		screen = 1;
		xx = 17;
		yy = 31;
	    }
	    else if (a [yy] [xx] == 11 && pok == 0)
	    {
		JOptionPane.showMessageDialog (null, "You cannot travel to Route 1 without a Pokemon", "No Pokemon",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 2)
		wild ();
	    else if (a [yy] [xx] == 5)
	    {
		JOptionPane.showMessageDialog (null, "Nobody is in the house.\n" + "Your rival Barry has already left for Veilstone City - First Gym.", "Cannot Enter",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 6)
	    {
		String input = JOptionPane.showInputDialog ("Please enter the password ");
		if (input.equalsIgnoreCase ("Battle"))
		{
		    JOptionPane.showMessageDialog (null, "Correct Password", "Password",
			    JOptionPane.INFORMATION_MESSAGE);
		    screen = 8;
		    xx = 31;
		    yy = 17;
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "WRONG PASSWORD\nCannot proceed to Battle Town,", "Password",
			    JOptionPane.ERROR_MESSAGE);
		    xx++;
		}
	    }
	    else if (a [yy] [xx] == 7)
	    {
		screen = 0;
		xx = 16;
		yy = 0;
	    }
	    else if (a [yy] [xx] == 9)
	    {
		JOptionPane.showMessageDialog (null, "Wild Pokemon\n" + "You can fight, if you win you get the password and have health restored\n" +
			"If you lose, you faint!!!", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 8)
	    {
		JOptionPane.showMessageDialog (null, "How to Battle\n" + "Different moves have different damages.\nChoose the right moves and you win.\nChoose the wrong ones and you lose.\n" +
			"If you lose, you faint!!!", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 3)
	    {
		JOptionPane.showMessageDialog (null, "Twinleaf Town\n" + "Make sure to treat your pokemon with respect\n" +
			"Continue on to Route 1 with your Pokemon", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 4)
	    {
		screen = 2;
		xx = 27;
		yy = 26;
	    }
	    else if (a [yy] [xx] == 14)
	    {
		screen = 0;
		xx = 9;
		yy = 16;
	    }
	    else if (a [yy] [xx] == 13 && pok < 1)
		/*if they haven't selected a pokemon (pok < 1) only then go to screen 3,
		otherwise don't go so that user can't select new pokemon;
		 so after their choice they cannot pick another pokemon
		 */
		{
		    screen = 3;
		}
	    else if (a [yy] [xx - 1] == 13 || a [yy] [xx + 1] == 13 || a [yy - 1] [xx] == 13)
		screen = 2;
	    else if (a [yy] [xx] == 12)
	    {
		screen = 4;

	    }
	    else if (a [yy] [xx - 1] == 12 || a [yy] [xx + 1] == 12 || a [yy - 1] [xx] == 12)
		screen = 2;
	    else if (a [yy] [xx] == 15)
	    {
		JOptionPane.showMessageDialog (null, "WHOA THERE!\nCan't barge into someone's house.", "Locked",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 16)
	    {
		JOptionPane.showMessageDialog (null, "NO MONEY TO BUY\nCannot go In.", "Locked",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 17)
	    {
		JOptionPane.showMessageDialog (null, "DON'T TRY JUMPING INTO The WELL", "Sign",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 18)
	    {
		JOptionPane.showMessageDialog (null, "DON'T TRY JUMPING INTO A WELL", "AHHH!!!",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 19)
	    {
		screen = 10;
		xx = 10;
		yy = 28;
	    }
	    else if (a [yy] [xx] == 20)
	    {
		JOptionPane.showMessageDialog (null, "Continue onto the Elite 4 if you've beaten the Gym Leader", "Sign",
			JOptionPane.INFORMATION_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 21)
	    {
		JOptionPane.showMessageDialog (null, "ROUTE BLOCKED\nSorry, Victory Road is Under Construction.", "BLOCKED",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 22)
	    {
		screen = 1;
		xx = 0;
		yy = 23;
	    }
	    else if (a [yy] [xx] == 23)
	    {
		JOptionPane.showMessageDialog (null, "The person will only let you in \nafter you've beaten the Elite 4.", "BLOCKED",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 24)
	    {
		screen = 9;
		xx = 20;
		yy = 29;
	    }
	    else if (a [yy] [xx] == 26)
	    {
		if (gymbadges == 0)
		    gymbattle ();
		else
		{
		    JOptionPane.showMessageDialog (null, "You've already obtained the leaf badge.", "Can't battle again.",
			    JOptionPane.ERROR_MESSAGE);
		    xx++;
		}
	    }
	    else if (a [yy] [xx] == 31)
	    {
		xx = 19;
		yy = 8;
	    }
	    else if (a [yy] [xx] == 27)
	    {
		xx = 11;
		yy = 9;
	    }
	    else if (a [yy] [xx] == 34)
	    {
		xx = 3;
		yy = 8;
	    }
	    else if (a [yy] [xx] == 29)
	    {
		xx = 28;
		yy = 11;
	    }
	    else if (a [yy] [xx] == 36)
	    {
		xx = 8;
		yy = 20;
	    }
	    else if (a [yy] [xx] == 41)
	    {
		xx = 3;
		yy = 15;
	    }
	    else if (a [yy] [xx] == 35)
	    {
		xx = 20;
		yy = 15;
	    }
	    else if (a [yy] [xx] == 38)
	    {
		xx = 14;
		yy = 14;
	    }
	    else if (a [yy] [xx] == 40)
	    {
		JOptionPane.showMessageDialog (null, "Teleporter not working.", "BROKEN",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 43)
	    {
		xx = 20;
		yy = 26;
	    }
	    else if (a [yy] [xx] == 44)
	    {
		xx = 12;
		yy = 23;
	    }
	    else if (a [yy] [xx] == 46)
	    {
		screen = 8;
		xx = 8;
		yy = 20;
	    }
	    else if (a [yy] [xx] == 45)
	    {
		if (gymbadges == 0)
		{
		    JOptionPane.showMessageDialog (null, "Welcome to the Gym.\nAs you can see this gym is a maze of teleporters.\nBut they're pretty straightforward.", "Help Guy",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "CONGRATULATIONS.", "Help Guy",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		xx++;
	    }
	    else if (a [yy] [xx] == 30 || a [yy] [xx] == 32 || a [yy] [xx] == 33 || a [yy] [xx] == 37 || a [yy] [xx] == 39 || a [yy] [xx] == 42)
	    {
		if (gymbadges == 0)
		{
		    JOptionPane.showMessageDialog (null, "Good Luck with the Gym Leader", "Advice",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "CONGRATULATIONS.", "Advice",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		xx++;
	    }
	    else if (a [yy] [xx] == 50)
	    {
		JOptionPane.showMessageDialog (null, "CANNOT ENTER", "NO ENTRY",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 51)
	    {
		String[] possibleValues = {"Heal.", "No Thanks."};
		String selectedValue = (String) JOptionPane.showInputDialog (null, "We can heal your Pokemon.",
			"Heal", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		if (selectedValue.equals ("Heal."))
		{
		    hp = 300;
		    JOptionPane.showMessageDialog (null, "We have healed your Pokemon.\nGoodbye.", "Heal Pokemon",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "Goodbye.", "Heal Pokemon",
			    JOptionPane.INFORMATION_MESSAGE);
		}
		xx++;
	    }
	    else if (a [yy] [xx] == 52)
	    {
		JOptionPane.showMessageDialog (null, "CANNOT ENTER", "NO ENTRY",
			JOptionPane.ERROR_MESSAGE);
		xx++;
	    }
	    else if (a [yy] [xx] == 53)
	    {
		screen = 8;
		xx = 12;
		yy = 12;
	    }
	    else if (a [yy] [xx] == 0)
		xx++;
	}
    }


    public void pause (int p)  //to allow to pause for any amount of time
    {
	try
	{
	    Thread.sleep (p);
	}
	catch (InterruptedException m)
	{
	    ;
	}
    }


    public void title (Graphics g)  //so it looks like animation
    {
	for (int t = 0 ; t <= 50 ; t++)
	{
	    //different frames back to back to back with pauses in between or it'll be too fast to see
	    g.drawImage (titleone, 0, 0, this);
	    pause (5);
	    g.drawImage (titletwo, 0, 0, this);
	    pause (5);
	    g.drawImage (titlethree, 0, 0, this);
	    pause (5);

	}
	g.drawImage (titleone, 0, 0, this); //goes to the title screen after
    }





    public void mousePressed (MouseEvent e)
    {
	//get the x and y co-ordinates of the mouse
	int x = e.getX ();
	int y = e.getY ();
	//Title Screen
	if (screen == -1)
	{
	    Graphics g = getGraphics ();
	    if (x > 0 && x < 740 && y > 0 && y < 640)
	    {
		JOptionPane.showMessageDialog (null, "Welcome to the World of Pokemon.\nStart by going into your house.", "Welcome",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 0;

	    }
	}
	//each movement screen has arrays inputted into int a[] [] and then the movement coordinated by the movedpad method
	//Starter Map
	else if (screen == 0)
	{

	    int a[] [] = st;
	    movedpad (x, y, a);
	}

	//Route 1
	else if (screen == 1)
	{
	    int a[] [] = r1;
	    movedpad (x, y, a);
	}


	//Own House
	else if (screen == 2)
	{
	    int a[] [] = oh;
	    movedpad (x, y, a);
	}


	//profoak - talk method to talk
	else if (screen == 3)
	{
	    int a[] [] = oh;
	    movedpad (x, y, a);
	    talk (x, y);
	}


	//mom - talk method to talk
	else if (screen == 4)
	{
	    int a[] [] = oh;
	    movedpad (x, y, a);
	    talk (x, y);
	}
	//battle (comments inside apply for all battles after)
	else if (screen == 5)
	{
	    while (hp > 0 && ophp > 0 && screen == 5)
	    {
		String[] possibleValues = {"Blast Burn", "Flare Blitz", "Blue Flare", "Overheat", "Run"}; //gives options
		String selectedValue = (String) JOptionPane.showInputDialog (null, "Infernape has " + hp + "HP.\nChoose one of the attacks/options:",
			"Battle", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		int range = 0;
		// range is how effective the move is, firetypes are not effective against nidoking
		if (selectedValue.equals ("Blast Burn"))
		    range = 80;
		else if (selectedValue.equals ("Flare Blitz"))
		    range = 30;
		else if (selectedValue.equals ("Overheat"))
		    range = 50;
		else if (selectedValue.equals ("Blue Flare"))
		    range = 40;
		else //to run away
		    screen = 1;
		if (range > 0) //if you picked an attack
		    attacks (range, selectedValue, "Infernape", "Nidoking");
	    }

	    if (ophp < 1) //if you won
	    {
		JOptionPane.showMessageDialog (null, "You Won the Battle!!!\n The password to Route 1 is: BATTLE", "Win",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 1;
		hp = 250;
		/*restores hp a bit after win, so that if you're in the middle of wild pokemon zones
		you won't black out if you get into another fight
		*/
	    }
	    else if (hp < 1) //if you lost
	    {
		JOptionPane.showMessageDialog (null, "You Blacked Out!!!", "Loss",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 4; // sends to mom to heal, later in the game user will go to pokemon center
		xx = 26;
		yy = 6;

	    }
	    ophp = 300; //resets opponent hp to 300

	}
	else if (screen == 6)
	{
	    while (hp > 0 && ophp > 0 && screen == 6)
	    {
		String[] possibleValues = {"Frenzy Plant", "Leaf Storm", "Petal Dance", "Wood Hammer", "Run"};
		String selectedValue = (String) JOptionPane.showInputDialog (null, "Torterra has " + hp + "HP.\nChoose one of the attacks/options:",
			"Battle", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		int range = 0;
		// range is how effective the move is, grass types are effective against nidoking
		if (selectedValue.equals ("Frenzy Plant"))
		    range = 100;
		else if (selectedValue.equals ("Leaf Storm"))
		    range = 80;
		else if (selectedValue.equals ("Petal Dance"))
		    range = 75;
		else if (selectedValue.equals ("Wood Hammer"))
		    range = 60;
		else
		    screen = 1;
		if (range > 0)
		    attacks (range, selectedValue, "Torterra", "Nidoking");
	    }

	    if (ophp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Won the Battle!!!\n The password to Route 1 is: BATTLE", "Win",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 1;
		hp = 250; //restores hp a bit after win
	    }
	    else if (hp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Blacked Out!!!", "Loss",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 4; // sends to mom to heal, later in the game user will go to pokemon center
		xx = 26;
		yy = 6;

	    }
	    ophp = 300; //resets opponent hp to 300

	}
	else if (screen == 7)
	{
	    while (hp > 0 && ophp > 0 && screen == 7)
	    {
		String[] possibleValues = {"Hydro Cannon", "Aqua Tail", "Hydro Pump", "Water Pulse", "Run"};
		String selectedValue = (String) JOptionPane.showInputDialog (null, "Empoleon has " + hp + "HP.\nChoose one of the attacks/options:",
			"Battle", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		int range = 0;
		// range is how effective the move is, water types are super effective agains nidoking
		if (selectedValue.equals ("Hydro Cannon"))
		    range = 120;
		else if (selectedValue.equals ("Aqua Tail"))
		    range = 90;
		else if (selectedValue.equals ("Hydro Pump"))
		    range = 100;
		else if (selectedValue.equals ("Water Pulse"))
		    range = 60;
		else
		    screen = 1;
		if (range > 0)
		    attacks (range, selectedValue, "Empoleon", "Nidoking");
	    }

	    if (ophp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Won the Battle!!!\n The password to Route 1 is: BATTLE", "Win",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 1;
		hp = 250; //restores hp a bit after win
	    }
	    else if (hp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Blacked Out!!!", "Loss",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 4; // sends to mom to heal, later in the game user will go to pokemon center
		xx = 26;
		yy = 6;

	    }
	    ophp = 300; //resets opponent hp to 300

	}
	else if (screen == 8) //battle town
	{
	    int a[] [] = bt;
	    movedpad (x, y, a);
	}
	else if (screen == 9) //gym
	{
	    int a[] [] = gm;
	    movedpad (x, y, a);
	}
	else if (screen == 10) //pokemon center
	{
	    int a[] [] = pc;
	    movedpad (x, y, a);
	}
	else if (screen == 11)//gym battle - torterra
	{
	    
	    while (hp > 0 && ophp > 0 && screen == 11)
	    {
		String[] possibleValues = {"Frenzy Plant", "Leaf Storm", "Petal Dance", "Wood Hammer"};//no run away HAHA
		String selectedValue = (String) JOptionPane.showInputDialog (null, "Torterra has " + hp + "HP.\nChoose one of the attacks:",
			"Gym Battle", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		int range = 0;
		// range is how effective the move is, grass types are effective against nidoking
		if (selectedValue.equals ("Frenzy Plant"))
		    range = 100;
		else if (selectedValue.equals ("Leaf Storm"))
		    range = 80;
		else if (selectedValue.equals ("Petal Dance"))
		    range = 75;
		else
		    range = 60;


		attacks (range, selectedValue, "Torterra", "Scizor");
	    }

	    if (ophp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Won the Battle!!!\nYOU OBTAINED THE LEAF BADGE.", "Win",
			JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog (null, "Your rival Barry also won!\nHe's at the Elite 4.", "Gym Leader",
			JOptionPane.INFORMATION_MESSAGE);
		
		screen = 9;//goes to entrance of gym
		xx = 20;
		yy = 29;
		hp = 250; //restores hp a bit after win
	    }
	    else if (hp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Blacked Out!!!", "Loss",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 10; // sends to pokemon center to heal
		xx = 9;
		yy = 16;

	    }
	    //get a gymbadge so you can't fight same person again
	    gymbadges = (ophp < 1) ? 1:
	    0;
	    ophp = 300; //resets opponent hp to 300

	}
	else if (screen == 12)//gym battle - infernape
	{
	    
	    while (hp > 0 && ophp > 0 && screen == 12)
	    {
		String[] possibleValues = {"Blast Burn", "Flare Blitz", "Blue Flare", "Overheat"};//no run away HAHA
		String selectedValue = (String) JOptionPane.showInputDialog (null, "Infernape has " + hp + "HP.\nChoose one of the attacks:",
			"Gym Battle", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		int range = 0;
		// range is how effective the move is, firetypes are not effective against nidoking
		if (selectedValue.equals ("Blast Burn"))
		    range = 80;
		else if (selectedValue.equals ("Flare Blitz"))
		    range = 30;
		else if (selectedValue.equals ("Overheat"))
		    range = 50;
		else
		    range = 40;


		attacks (range, selectedValue, "Infernape", "Scizor");
	    }

	    if (ophp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Won the Battle!!!\nYOU OBTAINED THE LEAF BADGE.", "Win",
			JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog (null, "Your rival Barry also won!\nHe's at the Elite 4.", "Gym Leader",
			JOptionPane.INFORMATION_MESSAGE);
		
		screen = 9;//goes to entrance of gym
		xx = 20;
		yy = 29;
		hp = 250;
		/*restores hp a bit after win, so that if you're in the middle of wild pokemon zones
		you won't black out if you get into another fight
		*/
	    }
	    else if (hp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Blacked Out!!!", "Loss",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 10; // sends to pokemon center to heal
		xx = 9;
		yy = 16;

	    }
	    //get a gymbadge so you can't fight same person again
	    gymbadges = (ophp < 1) ? 1:
	    0;
	    ophp = 300; //resets opponent hp to 300

	}
	else if (screen == 13)//gym battle - empoleon
	{
	    
	    while (hp > 0 && ophp > 0 && screen == 13)
	    {
		String[] possibleValues = {"Hydro Cannon", "Aqua Tail", "Hydro Pump", "Water Pulse"};//no run away HAHA
		String selectedValue = (String) JOptionPane.showInputDialog (null, "Empoleon has " + hp + "HP.\nChoose one of the attacks:",
			"Gym Battle", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);
		int range = 0;
		// range is how effective the move is, water types are super effective agains nidoking
		if (selectedValue.equals ("Hydro Cannon"))
		    range = 120;
		else if (selectedValue.equals ("Aqua Tail"))
		    range = 90;
		else if (selectedValue.equals ("Hydro Pump"))
		    range = 100;
		else
		    range = 60;

		attacks (range, selectedValue, "Empoleon", "Scizor");
	    }

	    if (ophp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Won the Battle!!!\nYOU OBTAINED THE LEAF BADGE.", "Win",
			JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog (null, "Your rival Barry also won!\nHe's at the Elite 4.", "Gym Leader",
			JOptionPane.INFORMATION_MESSAGE);
		
		screen = 9;//goes to entrance of gym
		xx = 20;
		yy = 29;
		hp = 250; //restores hp a bit after win
	    }
	    else if (hp < 1)
	    {
		JOptionPane.showMessageDialog (null, "You Blacked Out!!!", "Loss",
			JOptionPane.INFORMATION_MESSAGE);
		screen = 10; // sends to pokemon center to heal
		xx = 9;
		yy = 16;

	    }
	    //get a gymbadge so you can't fight same person again
	    gymbadges = (ophp < 1) ? 1:
	    0;
	    ophp = 300; //resets opponent hp to 300

	}
	repaint ();
    }


    public void attacks (int range, String whichatt, String whichpok, String opppok)  //attacks so you can type in input and it'll attack for you
    {
	int opatt = (int) (Math.random () * 50) + 50;//attack for opponent
	int ownatt = (int) (Math.random () * range) + 50;//own attack dpending on range
	ophp -= ownatt;
	hp -= opatt;
	if (hp > 0 && ophp > 0)//if both opp and you are alive
	{
	    JOptionPane.showMessageDialog (null, whichpok + " used " + whichatt + "\n" + opppok + " took " + ownatt + " damage\n" +
		    opppok + " attacked.\n" + whichpok + " took " + opatt + " damage.\n" + whichpok + " has " + hp + "HP left.\n" +
		    opppok + " has " + ophp + "HP left.", "Battle",
		    JOptionPane.INFORMATION_MESSAGE);
	}
	else if (hp < 1 && ophp > 0)//you died
	{
	    JOptionPane.showMessageDialog (null, whichpok + " used " + whichatt + "\n" + opppok + " took " + ownatt + " damage\n" +
		    opppok + " attacked.\n" + whichpok + " took " + opatt + " damage.\n" + whichpok + " has 0HP left.\n" +
		    opppok + " has " + ophp + "HP left.", "Battle",
		    JOptionPane.INFORMATION_MESSAGE);
	}
	else if (ophp < 1 && hp > 0)//opp died
	{
	    JOptionPane.showMessageDialog (null, whichpok + " used " + whichatt + "\n" + opppok + " took " + ownatt + " damage\n" +
		    opppok + " attacked.\n" + whichpok + " took " + opatt + " damage.\n" + whichpok + " has " + hp + "HP left.\n" +
		    opppok + " has 0HP left.", "Battle",
		    JOptionPane.INFORMATION_MESSAGE);
	}
	else if (ophp < 1 && hp < 1)//if both died but sincie you attacked first, you win
	{
	    JOptionPane.showMessageDialog (null, whichpok + " used " + whichatt + "\n" + opppok + " fainted.\n", "Battle",
		    JOptionPane.INFORMATION_MESSAGE);
	}
    }


    public void update (Graphics g)
    { //Overide the regular update method so it doesn't clear the screen before it draws (Gets rid of annoying white flicker)
	paint (g);
    }


    //which direction the guy is facing
    public void direc (Graphics g)
    {
	if (dir == 1)
	    g.drawImage (fup, xx * 20, yy * 20, this);
	else if (dir == 2)
	    g.drawImage (fdown, xx * 20, yy * 20, this);
	else if (dir == 3)
	    g.drawImage (fright, xx * 20, yy * 20, this);
	else
	    g.drawImage (fleft, xx * 20, yy * 20, this);
    }


    //which map to output depending on screen # and which direction to face - calls direc method for direction
    public void maps (int b, Graphics g)
    {
	if (b == 0)
	{
	    g.drawImage (StarterMap, 0, 0, this);
	    direc (g);
	}
	else if (b == -1)
	{
	    title (g);
	}

	else if (b == 1)
	{
	    g.drawImage (Route1, 0, 0, this);
	    direc (g);
	}


	else if (b == 2)
	{
	    g.drawImage (Ownhouse, 0, 0, this);
	    direc (g);
	}


	else if (b == 3 || b == 4)
	{
	    g.drawImage (profoaktalk, 0, 0, this);
	    direc (g);
	}
	else if (b == 5)
	{
	    g.drawImage (infnido1, 0, 0, this);
	}
	else if (b == 6)
	{
	    g.drawImage (tornido, 0, 0, this);
	}
	else if (b == 7)
	{
	    g.drawImage (empnido, 0, 0, this);
	}
	else if (b == 8)
	{
	    g.drawImage (Battletown, 0, 0, this);
	    direc (g);
	}
	else if (b == 9)
	{
	    g.drawImage (gym, 0, 0, this);
	    direc (g);
	}
	else if (b == 10)
	{
	    g.drawImage (center, 0, 0, this);
	    direc (g);
	}
	else if (b == 11)
	{
	    g.drawImage (torgym, 0, 0, this);
	}
	else if (b == 12)
	{
	    g.drawImage (infgym, 0, 0, this);
	}
	else if (b == 13)
	{
	    g.drawImage (empgym, 0, 0, this);
	}
    }


    public void paint (Graphics g)
    {
	if (screen == -1)
	{

	    maps (-1, g);
	}
	else if (screen == 0) //Starter Map
	{
	    maps (0, g);
	    showStatus ("Welcome to the Pokemon Game");
	}
	else if (screen == 1) //Route 1
	{
	    maps (1, g);
	    showStatus ("Welcome to Route 1. Here you can battle wild Pokemon. Wild Pokemon can be found on the wild grass.");
	}


	else if (screen == 2)//ownhouse
	{
	    maps (2, g);
	    showStatus ("This is your own house. Talk to your mom and Professor Rowan.");
	}


	else if (screen == 3)//talk prof
	{
	    maps (3, g);
	    showStatus ("Talk to Professor Rowan.");
	}


	else if (screen == 4)//talk mom
	{
	    maps (4, g);
	    showStatus ("Talk to Mom.");
	}
	else if (screen == 5)//wild battle with different pokemon
	{
	    maps (5, g);
	    showStatus ("Wild Pokemon Battle");
	}
	else if (screen == 6)//wild battle with different pokemon
	{
	    maps (6, g);
	    showStatus ("Wild Pokemon Battle");
	}
	else if (screen == 7)//wild battle with different pokemon
	{
	    maps (7, g);
	    showStatus ("Wild Pokemon Battle");
	}
	else if (screen == 8)//battle town
	{
	    maps (8, g);
	    showStatus ("You've reached Veilstone City. Good Luck with the Gym Leader.");
	}
	else if (screen == 9)//gym
	{
	    maps (9, g);
	    showStatus ("Welcome to the (Giant)Gym.");
	}
	else if (screen == 10)//pokecenter
	{
	    maps (10, g);
	    showStatus ("Welcome to the (Giant) Pokemon Center. Here you can heal your pokemon.");
	}
	else if (screen == 11)//gym battle with different pokemon
	{
	    maps (11, g);
	    showStatus ("Gym Battle.");
	}
	else if (screen == 12)//gym battle with different pokemon
	{
	    maps (12, g);
	    showStatus ("Gym Battle.");
	}
	else if (screen == 13)//gym battle with different pokemon
	{
	    maps (13, g);
	    showStatus ("Gym Battle.");
	}

    }
}


