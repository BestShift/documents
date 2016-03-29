    @Override
    protected void onDraw(Canvas canvas) {
        int w = getWidth() / 2;
        int h = getHeight() / 2;

        Paint drawblack = new Paint();
        drawblack.setColor(Color.BLACK);
        drawblack.setStyle(Paint.Style.STROKE);
        drawblack.setStyle(Paint.Style.FILL);
        Paint p = new Paint();
        // smooths
        p.setAntiAlias(true);
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(4.5f);
        // opacity
        //p.setAlpha(0x80); //
        phi = (int) (Math.random() * (358  + 1) +0);
        System.out.println("in:" +phi);
        int a=runden(phi);
        System.out.println("out:" + a);

        radiusgeneriert=(int) (Math.random() * (radius  + 1) +0);
        System.out.println("radius:" + radiusgeneriert);
        x= (float) (radiusgeneriert*Math.cos(a));
        y= (float) (radiusgeneriert*Math.sin(a));
        System.out.println("x:" + x+ "y:" + y);
        xvalues.add(x);
        yvalues.add(y);
        xvalues.toArray();
        yvalues.toArray();
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, p);
        canvas.drawCircle((getWidth() / 2) + x, (getHeight() / 2) + y, 10, drawblack);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        invalidate();
        postInvalidate();

        for (int i = 0; i < xvalues.size(); i++) {
            p.setColor(Color.BLACK);
            p.setStyle(Paint.Style.FILL);
            canvas.drawCircle((getWidth() / 2) + xvalues.get(i), (getHeight() / 2) + yvalues.get(i), 3, p);
            invalidate();
            postInvalidate();
            if (xvalues.get(i) == null) {
                break;
            }

        }


    

