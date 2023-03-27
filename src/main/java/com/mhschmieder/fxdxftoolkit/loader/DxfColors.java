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
package com.mhschmieder.fxdxftoolkit.loader;

import javafx.scene.paint.Color;

public final class DxfColors {

    // Color lookup from DXF Color Index (1 to 255) to standard RGB Colors.
    private static final int[][] RGB_COLORS           = {
                                                          // Colores
                                                          // básicos
                                                          { 255, 0, 0 },
                                                          { 255, 255, 0 },
                                                          { 0, 255, 0 },
                                                          { 0, 255, 255 },
                                                          { 0, 0, 255 },
                                                          { 255, 0, 255 },
                                                          { 255, 255, 255 },
                                                          { 128, 128, 128 },
                                                          { 192, 192, 192 },
                                                          // Paleta de
                                                          // Colores
                                                          // AUTOCAD
                                                          /* 1 */{ 255, 0, 0 },
                                                          { 255, 127, 127 },
                                                          { 204, 0, 0 },
                                                          { 204, 102, 102 },
                                                          { 153, 0, 0 },
                                                          { 153, 76, 76 },
                                                          { 127, 0, 0 },
                                                          { 127, 63, 63 },
                                                          { 76, 0, 0 },
                                                          { 76, 38, 38 },
                                                          /* 2 */{ 255, 63, 0 },
                                                          { 255, 159, 127 },
                                                          { 204, 51, 0 },
                                                          { 204, 127, 102 },
                                                          { 153, 38, 0 },
                                                          { 153, 95, 76 },
                                                          { 127, 31, 0 },
                                                          { 127, 79, 63 },
                                                          { 76, 19, 0 },
                                                          { 76, 47, 38 },
                                                          /* 3 */{ 255, 127, 0 },
                                                          { 255, 191, 127 },
                                                          { 204, 102, 0 },
                                                          { 204, 153, 102 },
                                                          { 153, 76, 0 },
                                                          { 153, 114, 76 },
                                                          { 127, 63, 0 },
                                                          { 127, 95, 63 },
                                                          { 76, 38, 0 },
                                                          { 76, 57, 38 },
                                                          /* 4 */{ 255, 191, 0 },
                                                          { 255, 223, 127 },
                                                          { 204, 153, 0 },
                                                          { 204, 178, 102 },
                                                          { 153, 114, 0 },
                                                          { 153, 123, 76 },
                                                          { 127, 95, 0 },
                                                          { 127, 111, 63 },
                                                          { 76, 57, 0 },
                                                          { 76, 66, 38 },
                                                          /* 5 */{ 255, 255, 0 },
                                                          { 255, 255, 127 },
                                                          { 204, 204, 0 },
                                                          { 204, 204, 102 },
                                                          { 153, 153, 0 },
                                                          { 153, 153, 76 },
                                                          { 127, 127, 0 },
                                                          { 127, 127, 63 },
                                                          { 76, 76, 0 },
                                                          { 76, 76, 38 },
                                                          /* 6 */{ 191, 255, 0 },
                                                          { 223, 255, 127 },
                                                          { 153, 204, 0 },
                                                          { 178, 204, 102 },
                                                          { 114, 153, 0 },
                                                          { 133, 153, 76 },
                                                          { 95, 127, 0 },
                                                          { 111, 127, 63 },
                                                          { 57, 76, 0 },
                                                          { 66, 76, 38 },
                                                          /* 7 */{ 127, 255, 0 },
                                                          { 191, 255, 127 },
                                                          { 102, 204, 0 },
                                                          { 153, 204, 102 },
                                                          { 76, 153, 0 },
                                                          { 114, 153, 76 },
                                                          { 63, 127, 0 },
                                                          { 95, 127, 63 },
                                                          { 38, 76, 0 },
                                                          { 57, 76, 38 },
                                                          /* 8 */{ 63, 255, 0 },
                                                          { 159, 255, 127 },
                                                          { 51, 204, 0 },
                                                          { 127, 204, 102 },
                                                          { 38, 153, 0 },
                                                          { 95, 153, 76 },
                                                          { 31, 127, 0 },
                                                          { 79, 127, 63 },
                                                          { 19, 76, 0 },
                                                          { 47, 76, 38 },
                                                          /* 9 */{ 0, 255, 0 },
                                                          { 127, 255, 127 },
                                                          { 0, 204, 0 },
                                                          { 102, 204, 102 },
                                                          { 0, 153, 0 },
                                                          { 76, 153, 76 },
                                                          { 0, 127, 0 },
                                                          { 63, 127, 63 },
                                                          { 0, 76, 0 },
                                                          { 38, 76, 38 },
                                                          /* 10 */{ 0, 255, 63 },
                                                          { 127, 255, 159 },
                                                          { 0, 204, 51 },
                                                          { 102, 204, 127 },
                                                          { 0, 153, 38 },
                                                          { 76, 153, 95 },
                                                          { 0, 127, 31 },
                                                          { 63, 127, 79 },
                                                          { 0, 76, 19 },
                                                          { 38, 76, 47 },
                                                          /* 11 */{ 0, 255, 127 },
                                                          { 127, 255, 191 },
                                                          { 0, 204, 102 },
                                                          { 102, 204, 153 },
                                                          { 0, 153, 76 },
                                                          { 76, 153, 114 },
                                                          { 0, 127, 63 },
                                                          { 63, 127, 95 },
                                                          { 0, 76, 38 },
                                                          { 38, 76, 57 },
                                                          /* 12 */{ 0, 255, 191 },
                                                          { 127, 255, 223 },
                                                          { 0, 204, 153 },
                                                          { 102, 204, 178 },
                                                          { 0, 153, 114 },
                                                          { 76, 153, 133 },
                                                          { 0, 127, 95 },
                                                          { 63, 127, 111 },
                                                          { 0, 76, 57 },
                                                          { 38, 76, 66 },
                                                          /* 13 */{ 0, 255, 255 },
                                                          { 127, 255, 255 },
                                                          { 0, 204, 204 },
                                                          { 102, 204, 204 },
                                                          { 0, 153, 153 },
                                                          { 76, 153, 153 },
                                                          { 0, 127, 127 },
                                                          { 63, 127, 127 },
                                                          { 0, 76, 76 },
                                                          { 38, 76, 76 },
                                                          /* 14 */{ 0, 191, 255 },
                                                          { 127, 223, 255 },
                                                          { 0, 153, 204 },
                                                          { 102, 178, 204 },
                                                          { 0, 114, 153 },
                                                          { 76, 133, 153 },
                                                          { 0, 95, 127 },
                                                          { 63, 111, 127 },
                                                          { 0, 57, 76 },
                                                          { 38, 66, 76 },
                                                          /* 15 */{ 0, 127, 255 },
                                                          { 127, 191, 255 },
                                                          { 0, 102, 204 },
                                                          { 102, 153, 204 },
                                                          { 0, 76, 153 },
                                                          { 76, 114, 153 },
                                                          { 0, 63, 127 },
                                                          { 63, 95, 127 },
                                                          { 0, 38, 76 },
                                                          { 38, 57, 76 },
                                                          /* 16 */{ 0, 63, 255 },
                                                          { 127, 159, 255 },
                                                          { 0, 51, 204 },
                                                          { 102, 127, 204 },
                                                          { 0, 38, 153 },
                                                          { 76, 95, 153 },
                                                          { 0, 31, 127 },
                                                          { 63, 79, 127 },
                                                          { 0, 19, 76 },
                                                          { 38, 47, 76 },
                                                          /* 17 */{ 0, 0, 255 },
                                                          { 127, 127, 255 },
                                                          { 0, 0, 204 },
                                                          { 102, 102, 204 },
                                                          { 0, 0, 153 },
                                                          { 76, 76, 153 },
                                                          { 0, 0, 127 },
                                                          { 63, 63, 127 },
                                                          { 0, 0, 76 },
                                                          { 38, 38, 76 },
                                                          /* 18 */{ 63, 0, 255 },
                                                          { 159, 127, 255 },
                                                          { 51, 0, 204 },
                                                          { 127, 102, 204 },
                                                          { 38, 0, 153 },
                                                          { 95, 76, 153 },
                                                          { 31, 0, 127 },
                                                          { 79, 63, 127 },
                                                          { 19, 0, 76 },
                                                          { 47, 38, 76 },
                                                          /* 19 */{ 127, 0, 255 },
                                                          { 191, 127, 255 },
                                                          { 102, 0, 204 },
                                                          { 153, 102, 204 },
                                                          { 76, 0, 153 },
                                                          { 114, 76, 153 },
                                                          { 63, 0, 127 },
                                                          { 95, 63, 127 },
                                                          { 38, 0, 76 },
                                                          { 57, 38, 76 },
                                                          /* 20 */{ 191, 0, 255 },
                                                          { 223, 127, 255 },
                                                          { 153, 0, 204 },
                                                          { 178, 102, 204 },
                                                          { 114, 0, 153 },
                                                          { 133, 76, 153 },
                                                          { 95, 0, 127 },
                                                          { 111, 63, 127 },
                                                          { 57, 0, 76 },
                                                          { 66, 38, 76 },
                                                          /* 21 */{ 255, 0, 255 },
                                                          { 255, 127, 255 },
                                                          { 204, 0, 204 },
                                                          { 204, 102, 204 },
                                                          { 153, 0, 153 },
                                                          { 153, 76, 153 },
                                                          { 127, 0, 127 },
                                                          { 127, 63, 127 },
                                                          { 76, 0, 76 },
                                                          { 76, 38, 76 },
                                                          /* 22 */{ 255, 0, 191 },
                                                          { 255, 127, 223 },
                                                          { 204, 0, 153 },
                                                          { 204, 102, 178 },
                                                          { 153, 0, 114 },
                                                          { 153, 76, 133 },
                                                          { 127, 0, 95 },
                                                          { 127, 63, 111 },
                                                          { 76, 0, 57 },
                                                          { 76, 38, 66 },
                                                          /* 23 */{ 255, 0, 127 },
                                                          { 255, 127, 191 },
                                                          { 204, 0, 102 },
                                                          { 204, 102, 153 },
                                                          { 153, 0, 76 },
                                                          { 153, 76, 114 },
                                                          { 127, 0, 63 },
                                                          { 127, 63, 95 },
                                                          { 76, 0, 38 },
                                                          { 76, 38, 57 },
                                                          /* 24 */{ 255, 0, 63 },
                                                          { 255, 127, 159 },
                                                          { 204, 0, 51 },
                                                          { 204, 102, 127 },
                                                          { 153, 0, 38 },
                                                          { 153, 76, 95 },
                                                          { 127, 0, 31 },
                                                          { 127, 63, 79 },
                                                          { 76, 0, 19 },
                                                          { 76, 38, 47 },
                                                          // Grises
                                                          { 51, 51, 51 },
                                                          { 91, 91, 91 },
                                                          { 132, 132, 132 },
                                                          { 173, 173, 173 },
                                                          { 214, 214, 214 },
                                                          { 255, 255, 255 } };

    public static final int      NUMBER_OF_DXF_COLORS = 255;
    public static final int      COLOR_BY_BLOCK_INDEX = 0;
    public static final int      COLOR_BY_LAYER_INDEX = 256;
    public static final Color    COLOR_DEFAULT        = Color.rgb( 255, 255, 255 );

    // JavaFX Color values in RGB format.
    private static Color[]       _rgbColors           = null;

    public static Color indexToColor( final int dxfColorIndex ) {
        // If this is the first time the method has been called, use the
        // lookup table to make JavaFX colors from the cached RGB values.
        if ( _rgbColors == null ) {
            _rgbColors = new Color[ NUMBER_OF_DXF_COLORS ];
            for ( int i = 0; i < NUMBER_OF_DXF_COLORS; i++ ) {
                _rgbColors[ i ] = Color
                        .rgb( RGB_COLORS[ i ][ 0 ], RGB_COLORS[ i ][ 1 ], RGB_COLORS[ i ][ 2 ] );
            }
        }

        // As DXF Color Index of zero is a special flag to get the color from
        // the parent vs. an actual color table lookup index, we must adjust the
        // DXF Color Index before using it to look up the RGB color values.
        final int rgbColorIndex = dxfColorIndex - 1;

        // Ignore the two extrema as they are special flags for color-by-parent
        // and color-by-layer. Use the default color in those cases, as the
        // color index should have already been adjusted outside this call, to
        // one that is within range of the DXF color lookup table for RGB's.
        final Color rgbColor = ( dxfColorIndex > COLOR_BY_BLOCK_INDEX )
                && ( dxfColorIndex < COLOR_BY_LAYER_INDEX )
                    ? _rgbColors[ rgbColorIndex ]
                    : COLOR_DEFAULT;

        return rgbColor;
    }

}// class DxfColors
