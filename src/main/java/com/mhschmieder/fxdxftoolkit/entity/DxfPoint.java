/**
 * MIT License
 *
 * Copyright (c) 2020, 2023 Mark Schmieder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the FxDxfToolkit Library
 *
 * You should have received a copy of the MIT License along with the
 * FxDxfToolkit Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxdxftoolkit
 */
package com.mhschmieder.fxdxftoolkit.entity;

import com.mhschmieder.fxdxftoolkit.geometry.FxShapeContainer;
import com.mhschmieder.fxdxftoolkit.reader.DxfGroupCodes;
import com.mhschmieder.fxdxftoolkit.reader.DxfPairContainer;
import com.mhschmieder.fxdxftoolkit.reader.DxfReaderException;
import com.mhschmieder.fxdxftoolkit.reader.EntityType;
import com.mhschmieder.fxdxftoolkit.structure.DxfDocument;

import javafx.scene.transform.Affine;

public class DxfPoint extends DxfEntity {

    public double _x;
    public double _y;
    public double _z;

    public DxfPoint( final DxfDocument pdoc,
                     final DxfPairContainer pc,
                     final EntityType entityType,
                     final boolean ignorePaperSpace )
            throws DxfReaderException {
        super( pdoc, pc, entityType, ignorePaperSpace );
    }

    // TODO: Implement this, using the PDMODE and PDSIZE global variables to
    // determine the shape to use for the "displayable point", vs. assuming just
    // a point on screen (done as line with start=end).
    @Override
    public boolean convertToFxShapes( final FxShapeContainer fxShapeContainer,
                                      final Affine transform,
                                      final double strokeScale ) {
        // final Point2D point = new Point2D( _x, _y );

        // TODO: Review what this ends up doing, with no geometry added.
        // return _dxfDoc.getLayer( _layer ).isLayerOn();
        return false;
    }

    @Override
    protected void parseEntityProperties( final DxfPairContainer pc ) {
        _x = Double.parseDouble( pc.getValue( DxfGroupCodes.CODE10 ) );
        _y = Double.parseDouble( pc.getValue( DxfGroupCodes.CODE20 ) );
        _z = Double.parseDouble( pc.getValue( DxfGroupCodes.CODE30 ) );
    }

}// class DxfPoint
