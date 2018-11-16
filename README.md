# Android 进阶
## 第一章 事件传递

### 1.1触摸事件的类型
*        MotionEvent.ACTION_DOWN:
*        MotionEvent.ACTION_MOVE:
*        MotionEvent.ACTION_UP:
### 1.2事件传递的三个阶段
* 分发

    ```javascript
            @Override
            public boolean dispatchTouchEvent(MotionEvent event) {
            //方法返回true，当前界面消费时间，返回super.dispatchTouchEvent(event)表示继续分发改时间
                return super.dispatchTouchEvent(event);
            }
    ```

* 拦截
* 消费:返回True消费
    ```javascript
          @Override
            public boolean onTouchEvent(MotionEvent event) {
                return super.onTouchEvent(event);
            }
   ```
# 第四章 Support Annotation Library

            进入正题，Support Annotation Library是从Android Support Library 19.1开始引入的一个全新的函数包，
        它包含一系列有用的元注解，用来帮助开发者在编译期间发现可能存在的bug，Support Library本身也使用
        Annotation Library 提供的注解来完善自身的代码质量，Android Studio 提供可视化的交互以便开发者发现问题。
            Android Support Library 发展到现在已经不止是一个jar包了，而是拆分成多个独立的Jar包，例如support-v4、
        support-v7、gridlayout-v7、design、cardview-v7等等。而Annotation Libary 也是其中之一，默认情况下是不
        会包含在工程中的，如果我们的SDK已经安装了Android Support Repository，那么我们打开Project Structure 对
        话框，并选中一个Module，选中Dependencies选项，点击“+”按钮，在弹出的Choose Library Dependency 对话框
        中轻松找到Annotation Library。
        1.Nullness
              -@Nullable作用于函数参数或返回值，标记参数或返回值为可以空。
              -@NonNull作用于函数参数或返回值，标记参数或返回值为不能为空。

   ```javascript
              protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                ((MyTextView) findViewById(R.id.my_textview)).setOnClickListener(this);
                ((MyTextView) findViewById(R.id.my_textview)).setOnTouchListener(this);
                //support annotation使用
                test(null);//分析代码以后会找到这行错误的代码
            }

            private void test(@NonNull String str) {
                Log.i(TAG, "test: " + str);
            }
   ```
* [更多用法参看](https://blog.csdn.net/sw5131899/article/details/53842362)