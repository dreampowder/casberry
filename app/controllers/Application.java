package controllers;

import play.*;
import play.mvc.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void products(){
    	render();
    }
    
    public static void inventories(){
    	render();
    }
    
    public static void rebuildProducts() throws IOException{

    }
}