import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameSpinnerTick extends JPanel {
    private Polygon _polygon_orig = null;
    private Polygon _polygon = null;

    private int _tickWidth = 20;
    private int _tickHeight = 20;

    public GameSpinnerTick() {
        super();
        this.repaint();
    }

    public int getTickWidth() {
        return _tickWidth;
    }

    public void setTickWidth(int width) {
        _tickWidth = width;
    }

    public int getTickHeight() {
        return _tickHeight;
    }

    public void setTickHeight(int height) {
        _tickHeight = height;
    }

    public Polygon getPolygon() {
        return _polygon;
    }

    public void setPolygon(Polygon polygon) {
        _polygon_orig = polygon;
        _polygon = polygon;
        adjustPolygon();
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(rh);

        if (_polygon_orig == null) {
            _polygon = getTriangle();
        }
        else {
            adjustPolygon();
        }
        g2d.fillPolygon(_polygon);
    }

    private Polygon getTriangle() {
        Polygon polygon = new Polygon();
        polygon.addPoint(0, this.getHeight() / 2);
        polygon.addPoint(this.getWidth(), (int)(this.getHeight() / 2 - this.getWidth() * Math.tan(Math.toRadians(30))));
        polygon.addPoint(this.getWidth(), (int)(this.getHeight() / 2 + this.getWidth() * Math.tan(Math.toRadians(30))));
        return polygon;
    }

    private void adjustPolygon() {
        int i;
        // calculate width/height of the polygon
        int xmax = Integer.MIN_VALUE, xmin = Integer.MAX_VALUE;
        int ymax = xmax, ymin = xmin;
        for (i = 0; i < _polygon.xpoints.length; ++i) {
            if (_polygon.xpoints[i] > xmax) xmax = _polygon.xpoints[i];
            if (_polygon.xpoints[i] < xmin) xmin = _polygon.xpoints[i];
        }
        for (i = 0; i < _polygon.ypoints.length; ++i) {
            if (_polygon.ypoints[i] > ymax) ymax = _polygon.ypoints[i];
            if (_polygon.ypoints[i] < ymin) ymin = _polygon.ypoints[i];
        }
        int width = xmax - xmin;
        // scale polygon
        double factor = (double)this.getWidth() / width;
        for (i = 0; i < _polygon.xpoints.length; ++i) {
            _polygon.xpoints[i] *= factor;
            _polygon.ypoints[i] *= factor;
        }
        // calculate center of polygon
        int centerX = 0, centerY = 0;
        for (i = 0; i < _polygon.xpoints.length; ++i) {
            centerX += _polygon.xpoints[i];
        }
        centerX /= _polygon.xpoints.length;
        for (i = 0; i < _polygon.ypoints.length; ++i) {
            centerY += _polygon.ypoints[i];
        }
        centerY /= _polygon.ypoints.length;

        // translate polygon to center of the panel
        _polygon.translate(this.getWidth() / 2 - centerX, this.getHeight() / 2 - centerY);
    }

}
