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

import java.util.Collection;

import com.mhschmieder.fxdxftoolkit.geometry.FxShapeContainer;
import com.mhschmieder.fxdxftoolkit.loader.DxfLineType;
import com.mhschmieder.fxdxftoolkit.reader.DxfGroupCodes;
import com.mhschmieder.fxdxftoolkit.reader.DxfPairContainer;
import com.mhschmieder.fxdxftoolkit.reader.DxfReaderException;
import com.mhschmieder.fxdxftoolkit.reader.EntityType;
import com.mhschmieder.fxdxftoolkit.structure.DxfDocument;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Affine;

public class DxfLine extends DxfEntity {

    protected double _thickness;

    protected double _startX;
    protected double _startY;
    protected double _startZ;

    protected double _endX;
    protected double _endY;
    protected double _endZ;

    protected double _extrusionX;
    protected double _extrusionY;
    protected double _extrusionZ;

    public DxfLine( final DxfDocument pdoc,
                    final DxfPairContainer pc,
                    final EntityType entityType,
                    final boolean ignorePaperSpace )
            throws DxfReaderException {
        super( pdoc, pc, entityType, ignorePaperSpace );
    }

    @Override
    public boolean convertToFxShapes( final FxShapeContainer fxShapeContainer,
                                      final Affine transform,
                                      final double strokeScale ) {
        if ( !_dxfDoc.getLayer( _layer ).isLayerOn() ) {
            return false;
        }

        final Color color = getColor();
        final DxfLineType lineType = getLineType();

        final Line line = new Line( _startX, _startY, _endX, _endY );

        line.getTransforms().add( transform );
        line.setStroke( color );

        if ( ( lineType != null ) && !lineType.isContinuous() ) {
            final double lineTypeScale = _dxfDoc.getGlobalLineTypeScale() * _lineTypeScale;
            final Collection< Double > dashArrayCandidate = lineType.makeDashArray( lineTypeScale );
            final ObservableList< Double > dashArray = line.getStrokeDashArray();
            dashArray.setAll( dashArrayCandidate );
        }

        fxShapeContainer.addShape( strokeScale, line );

        return true;
    }

    @Override
    @SuppressWarnings("nls")
    protected void parseEntityProperties( final DxfPairContainer pc ) {
        _thickness = Double.parseDouble( pc.getValue( DxfGroupCodes.THICKNESS, "0" ) );

        _startX = Double.parseDouble( pc.getValue( DxfGroupCodes.CODE10 ) );
        _startY = Double.parseDouble( pc.getValue( DxfGroupCodes.CODE20 ) );
        _startZ = Double.parseDouble( pc.getValue( DxfGroupCodes.CODE30 ) );

        _endX = Double.parseDouble( pc.getValue( DxfGroupCodes.CODE11 ) );
        _endY = Double.parseDouble( pc.getValue( DxfGroupCodes.CODE21 ) );
        _endZ = Double.parseDouble( pc.getValue( DxfGroupCodes.CODE31 ) );

        _extrusionX = Double.parseDouble( pc.getValue( DxfGroupCodes.NORMAL_X, "0" ) );
        _extrusionY = Double.parseDouble( pc.getValue( DxfGroupCodes.NORMAL_Y, "0" ) );
        _extrusionZ = Double.parseDouble( pc.getValue( DxfGroupCodes.NORMAL_Z, "0" ) );
    }

}// class DxfLine
