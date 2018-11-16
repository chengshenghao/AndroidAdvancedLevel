# Android 进阶
## 第一章

### 1.1触摸事件的类型
        MotionEvent.ACTION_DOWN:
        MotionEvent.ACTION_MOVE:
        MotionEvent.ACTION_UP:
### 1.2事件传递的三个阶段
        分发

            @Override
            public boolean dispatchTouchEvent(MotionEvent event) {
            //方法返回true，当前界面消费时间，返回super.dispatchTouchEvent(event)表示继续分发改时间
                return super.dispatchTouchEvent(event);
            }

        拦截
        消费:返回True消费
          @Override
            public boolean onTouchEvent(MotionEvent event) {
                return super.onTouchEvent(event);
            }
