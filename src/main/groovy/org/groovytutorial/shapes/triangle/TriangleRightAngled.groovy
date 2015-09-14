package org.groovytutorial.shapes.triangle

import org.groovytutorial.shapes.Triangle

class TriangleRightAngled extends Triangle {
    static final String TRIANGLE_TYPE = 'Right-angled'

    TriangleRightAngled(Number sideA, Number sideB,
                        Number sideC = calculateSideC(sideA, sideB)) {
        super(sideA, sideB, sideC)
    }

    static Number calculateSideC(Number sideA, Number sideB) {
        Math.sqrt(sideA**2 + sideB**2)
    }

    @Override
    protected void calculateArea() {
        area = 0.5 * sides.a * sides.b
    }

    @Override
    String getDisplayInfo() {
        super.getDisplayInfo()
    }
}
