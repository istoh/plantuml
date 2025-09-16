package net.sourceforge.plantuml.emoji;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.klimt.color.HColors;
import net.sourceforge.plantuml.klimt.drawing.LimitFinder;
import net.sourceforge.plantuml.klimt.geom.XPoint2D;

public class SvgNanoParserTest {

        @Test
        public void rectAndLineAnchors() {
                final String svg = "<svg><rect id=\"r1\" x=\"10\" y=\"20\" width=\"30\" height=\"40\"/>"
                                + "<line id=\"l1\" x1=\"0\" y1=\"0\" x2=\"60\" y2=\"80\"/></svg>";
                final SvgNanoParser parser = new SvgNanoParser(svg);
                parser.drawU(LimitFinder.create(FileFormat.PNG.getDefaultStringBounder(), true), 1, HColors.BLACK, null);
                final XPoint2D rect = parser.getPoint("r1");
                assertEquals(25.0, rect.getX(), 0.001);
                assertEquals(40.0, rect.getY(), 0.001);
                final XPoint2D line = parser.getPoint("l1");
                assertEquals(30.0, line.getX(), 0.001);
                assertEquals(40.0, line.getY(), 0.001);
        }
}

