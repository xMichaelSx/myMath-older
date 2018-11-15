package myMath;

	import java.awt.Color;
	import javax.swing.JFrame;
	import de.erichseifert.gral.data.DataTable;
	import de.erichseifert.gral.plots.XYPlot;
	import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
	import de.erichseifert.gral.plots.lines.LineRenderer;
	import de.erichseifert.gral.plots.points.PointRenderer;
	import de.erichseifert.gral.ui.InteractivePanel;

	public class LinePlotTest extends JFrame {
	    public LinePlotTest(Polynom p) {
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(600, 400);
	        
	        DataTable data = new DataTable(Double.class, Double.class);
	        DataTable data2 = new DataTable(Double.class, Double.class);
	        for (double x = -20.0; x <= 16; x+=0.01) {
	            double y = p.f(x);
	            data.add(x, y);
	            if(y>p.f(x+0.01)&& y>p.f(x-0.01)) {
	            	data2.add(x, y);
	            	System.out.println("maximum point: "+"("+x+","+y+")");
	            }
	            else if(y<p.f(x+0.01)&& y<p.f(x-0.01)) {
	            	data2.add(x, y);
	            	System.out.println("minimum point: "+"("+x+","+y+")");
	            }
	        }
	       // XYPlot plot = new XYPlot(data);
	       System.out.println("the area is: "+p.areaneative(-2, 6, 0.01)); 
	        XYPlot plot = new XYPlot(data,data2);
	        getContentPane().add(new InteractivePanel(plot));
	        LineRenderer lines = new DefaultLineRenderer2D();
	        plot.setLineRenderers(data, lines);
	        Color color = new Color(0.4f, 0.3f, 1.0f);
	        Color color2 = new Color(0.7f, 0.0f, 0.0f);
	        plot.getPointRenderers(data).get(0).setColor(color);
	        plot.getPointRenderers(data2).get(0).setColor(color2);
	        plot.getLineRenderers(data).get(0).setColor(color);
	        
	       

	        
	        
	    }

	  //  public static void main(String[] args) {
	    //	Polynom p=new Polynom("2x^2+x");
	      //  LinePlotTest frame = new LinePlotTest(p);
	        //frame.setVisible(true);
	    //}
	}
	

