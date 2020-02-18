/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.arsla.clever_currency_exchange;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.hardware.camera2.params.BlackLevelPattern;
import android.util.Log;
import com.example.arsla.clever_currency_exchange.camera.GraphicOverlay;
//import com.google.android.gms.samples.vision.ocrreader.ui.camera.GraphicOverlay;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;

import java.util.List;

/**
 * Graphic instance for rendering TextBlock position, size, and ID within an associated graphic
 * overlay view.
 */
public class OcrGraphic extends GraphicOverlay.Graphic {

    private int id;

    private static final int TEXT_COLOR = Color.GREEN;

    private static Paint rectPaint;
    private static Paint textPaint;
    private TextBlock textBlock;

    OcrGraphic(GraphicOverlay overlay, TextBlock text) {
        super(overlay);


        textBlock = text;


        if (rectPaint == null) {
            rectPaint = new Paint();
            rectPaint.setColor(TEXT_COLOR);
            rectPaint.setStyle(Paint.Style.STROKE);
            rectPaint.setStrokeWidth(2.0f);
            rectPaint.setStyle(Paint.Style.STROKE);
        }



        if (textPaint == null) {
            textPaint = new Paint();
            textPaint.setColor(TEXT_COLOR);
            textPaint.setTextSize(120.0f);
            textPaint.setFakeBoldText(true);
            //textPaint.setShadowLayer(100,1,1, 1);
            //textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            //textPaint.setAlpha();
        }
        // Redraw the overlay, as this graphic has been added.
        postInvalidate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TextBlock getTextBlock() {
        return textBlock;
    }

    /**
     * Checks whether a point is within the bounding box of this graphic.
     * The provided point should be relative to this graphic's containing overlay.
     *
     * @param x An x parameter in the relative context of the canvas.
     * @param y A y parameter in the relative context of the canvas.
     * @return True if the provided point is contained within this graphic's bounding box.
     */
    public boolean contains(float x, float y) {
        if (textBlock == null) {
            return false;
        }
        RectF rect = new RectF(textBlock.getBoundingBox());
        rect = translateRect(rect);
        return rect.contains(x, y);
    }

    /**
     * Draws the text block annotations for position, size, and raw value on the supplied canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        if (textBlock == null) {
            return;
        }


        // Draws the bounding box around the TextBlock.
        RectF rect = new RectF(textBlock.getBoundingBox());
        rect = translateRect(rect);
        canvas.drawRect(rect, rectPaint);


        String keepNumerics = new String();
        String returnString = new String();
        double filteredText;


        // Break the text into multiple lines and draw each one according to its own bounding box.
        List<? extends Text> textComponents = textBlock.getComponents();
        for (Text currentText : textComponents) {

            keepNumerics = new String(currentText.getValue());
            keepNumerics = keepNumerics.replaceAll("[^\\d.]", "");
            try {
                filteredText = Double.valueOf(keepNumerics);
                filteredText = filteredText / MainActivity.fromToMultipler;
                filteredText = Math.round(filteredText * 100.0) / 100.0;
                returnString = returnString.valueOf(filteredText);
                Log.d("try statement", returnString);


            } catch (Exception e) {
                e.printStackTrace();
            }


            float left = translateX(currentText.getBoundingBox().left);
            float bottom = translateY(currentText.getBoundingBox().bottom);


            //canvas.drawText(filteredText.toString(), left, bottom, textPaint);
            canvas.drawText(returnString, left, bottom, textPaint);
        }

    }
}