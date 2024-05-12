/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class jpanelgradient extends JPanel{

  private Color colorStart = Color.BLACK;
  private Color colorEnd = Color.WHITE;

    public Color getColorStart() {
        return colorStart;
    }

    public void setColorStart(Color colorStart) {
        this.colorStart = colorStart;
    }

    public Color getColoerEnd() {
        return colorEnd;
    }

    public void setColoerEnd(Color coloerEnd) {
        this.colorEnd = coloerEnd;
    }
    public jpanelgradient(){
    }
  
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0,0,colorStart, getWidth(), getHeight(), colorEnd);
        g2d.setPaint(gradient);
        g2d.fillRect(0,0,getWidth(),getHeight());
    }
    
}
