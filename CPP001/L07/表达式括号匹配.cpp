#include<bits/stdc++.h>
using namespace std;

int main() {
    char exp[256];
    cin >> exp;
    stack<char> s;
    int len = strlen(exp);
    for (int i = 0; i < len; i++)
    {
        if (exp[i] == '(') { //左括号入栈
            s.push(exp[i]);
        }
        else if (exp[i] == ')' && !s.empty()) { //一定要判空，否则会报错
            s.pop();
        }
        else if (exp[i] == ')' && s.empty()) { //这里也是，必须要判空。
            cout << "NO";
            return 0;
        }
    }
    if (s.empty()) {//若栈为空则满足条件
        cout << "YES";
    }
    else {
        cout << "NO";
    }

    return 0;
}
