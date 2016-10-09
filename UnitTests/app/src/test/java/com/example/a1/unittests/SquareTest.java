package com.example.a1.unittests;

import com.example.a1.unittests.utiles.IFigure;
import com.example.a1.unittests.utiles.Square;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;

public class SquareTest {

    private IFigure mIFigure;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mIFigure = Mockito.spy(new Square(5.0));
    }

    @Test
    public void testAreaValues() {
        assertEquals(mIFigure.getArea(), 25.0);
    }

    @Test
    public void testPerimeterValues() {
        assertEquals(mIFigure.Perimeter(), 20.0);
    }

    @Test
    public void testIsValidSideLenght() {
        assertEquals(mIFigure.isValidSideLenght(), true);
    }
}
