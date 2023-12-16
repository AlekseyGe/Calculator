Language : us | [ru](./README.ru-RU.md)

## Calculator
This is a `fully working calculator`! The calculator was created in the `Android Studo` program, has a beautiful design and even a function for adding brackets

![Gif](gif.gif) 

 ## Compatibility

> The calculator was created in Android Studio and unfortunately `it cannot be used in Apple phones`

| <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Android_robot.svg/800px-Android_robot.svg.png_48x48.png" alt="Edge" width="45px" height="50px" /></br>Android | <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Apple_logo_grey.svg/1724px-Apple_logo_grey.svg.png" alt="Edge" width="45px" height="50px" /></br>Apple |
:-------:|:-------:|
|    ✔️  |    ❌  |

<h1 align="center">Important code moments</h1> 

The whole complexity of the code was contained in the `Clear` button

```
private void calculateResult() {
        try {
            String input = inputStringBuilder.toString();
            Expression expression = new ExpressionBuilder(input).build();
            double result = (int)expression.evaluate();
            resultTextView.setText(String.valueOf(result));

        } catch (Exception e) {
            resultTextView.setText("Error");
        }
    }
```
In order to create this button, I needed to connect `Expression Builder` to the project
