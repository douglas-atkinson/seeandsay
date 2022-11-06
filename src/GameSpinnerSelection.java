import javax.swing.*;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class GameSpinnerSelection extends JPanel {
    GameSpinner _spinner;
    GameSpinnerTick _tick;

    public GameSpinnerSelection(List<WedgeInfo> listOfWedges) throws Exception {
        _spinner = new GameSpinner(listOfWedges);
        _spinner.setLayout(null);
        _tick = new GameSpinnerTick();
        _tick.setLayout(null);
        this.setLayout(null);
        this.add(_spinner);
        this.add(_tick);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        _spinner.setBounds(0, 0, width - _tick.getTickWidth(), height);
        _tick.setBounds(width - _tick.getTickWidth(), 0, _tick.getTickWidth(), height);
    }

    public void hasBorders(boolean borders) {
        _spinner.hasBorders(borders);
    }

    public int getRadius() {
        return _spinner.getRadius();
    }

    public double getRotationAngle() {
        return _spinner.getRotationAngle();
    }

    public void setRotationAngle(double rotationAngle) {
        _spinner.setRotationAngle(rotationAngle);
    }

    public Font getGameSpinnerFont() {
        return _spinner.getFont();
    }

    public void setGameSpinnerFont(Font font) {
        super.setFont(font);
        _spinner.setFont(font);
    }

    public List<WedgeInfo> getListOfStrings() {
        return _spinner.getListOfWedges();
    }

    public void setListOfStrings(List<WedgeInfo> list) throws Exception {
        _spinner.setListOfWedges(list);
    }

    public double getSpinSpeed() {
        return _spinner.getSpinSpeed();
    }

    public double getMaxSpinSpeed() {
        return _spinner.getMaxSpinSpeed();
    }

    public void setMaxSpinSpeed(double speed) {
        _spinner.setMaxSpinSpeed(speed);
    }

    public double getSpinDeceleration() {
        return _spinner.getSpinDeceleration();
    }

    public void setSpinDeceleration(double deceleration) throws Exception {
        _spinner.setSpinDeceleration(deceleration);
    }

    public List<Color> getColorScheme() {
        return _spinner.getColorScheme();
    }

    public void setColorScheme(List<Color> colors) {
        _spinner.setColorScheme(colors);
    }

    public void addColor(Color color) {
        _spinner.addColor(color);
    }

    public WedgeInfo getSelectedWedge() {
        return _spinner.getSelectedWedge();
    }

    public boolean isSpinning() {
        return _spinner.isSpinning();
    }

    public void setShape(GameSpinner.Shape shape) {
        _spinner.setShape(shape);
    }

    public double getTickWidth() {
        return _tick.getTickWidth();
    }

    public void setTickWidth(int width) {
        _tick.setTickWidth(width);
        this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    public double getTickHeight() {
        return _tick.getTickHeight();
    }

    public void setTickHeight(int height) {
        _tick.setTickHeight(height);
    }

    public Polygon getTickPolygon() {
        return _tick.getPolygon();
    }

    public void setTickPolygon(Polygon polygon) {
        _tick.setPolygon(polygon);
    }

    public void spinStartAsync(double speed, int direction, double deceleration) throws Exception {
        _spinner.spinStartAsync(speed, direction, deceleration);
    }

    public void spinStop() {
        _spinner.spinStop();
    }

}
