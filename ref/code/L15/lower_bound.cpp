#include<bits/stdc++.h>
using namespace std;
const int maxn=1e5+10;
const int INF=INT_MAX;
#define LL long long

/*
lower_bound( )��upper_bound( )�������ö��ֲ��ҵķ�����һ���ź���������н��в��ҵġ�
�ڴ�С��������������У�
lower_bound(begin,end,key)���������beginλ�õ�end-1λ�ö��ֲ��ҵ�һ�����ڻ����
key�����֣��ҵ����ظ����ֵĵ�ַ���������򷵻�end��ͨ�����صĵ�ַ��ȥ��ʼ��ַbegin,
�õ��ҵ������������е��±ꡣ

upper_bound(begin,end,key)���������beginλ�õ�end-1λ�ö��ֲ��ҵ�һ������key��
���֣��ҵ����ظ����ֵĵ�ַ���������򷵻�end��ͨ�����صĵ�ַ��ȥ��ʼ��ַbegin,�õ���
�������������е��±ꡣ

�ڴӴ�С�����������У�����lower_bound()��upper_bound()
lower_bound( begin,end,key,greater<type>() ):�������beginλ�õ�end-1λ�ö��ֲ�
�ҵ�һ��С�ڻ����key�����֣��ҵ����ظ����ֵĵ�ַ���������򷵻�end��ͨ�����صĵ�ַ��
ȥ��ʼ��ַbegin,�õ��ҵ������������е��±ꡣ

upper_bound( begin,end,key,greater<type>() ):�������beginλ�õ�end-1λ�ö��ֲ�
�ҵ�һ��С��key�����֣��ҵ����ظ����ֵĵ�ַ���������򷵻�end��ͨ�����صĵ�ַ��ȥ��ʼ
��ַbegin,�õ��ҵ������������е��±ꡣ
*/
int main(){
	cout << "array usage:" << endl;
	int num[6]={1,2,4,7,15,34}; 
	sort(num,num+6);                          //����С�������� 
	int pos1=lower_bound(num,num+6,7)-num;    //���������е�һ�����ڻ���ڱ�������ֵ 
	int pos2=upper_bound(num,num+6,7)-num;    //���������е�һ�����ڱ�������ֵ
	cout<<pos1<<" "<<num[pos1]<<endl;
	cout<<pos2<<" "<<num[pos2]<<endl;
	sort(num,num+6, greater<int>());          //���Ӵ�С����
    // 34 15 7 4 2 1
	int pos3=lower_bound(num,num+6,7, greater<int>())-num;  //���������е�һ��С�ڻ���ڱ�������ֵ 
	int pos4=upper_bound(num,num+6,7, greater<int>())-num;  //���������е�һ��С�ڱ�������ֵ 
	cout<<pos3<<" "<<num[pos3]<<endl;
	cout<<pos4<<" "<<num[pos4]<<endl;
 
    cout<<"vector usage:"<<endl;
    vector<int> vec;
    for (int i = 0; i < 6; i++)
    {
        vec.push_back(num[i]);
    }
    sort(vec.begin(), vec.end());            //����С�������� 
     //���������е�һ�����ڻ���ڱ�������ֵ 
	pos1=lower_bound(vec.begin(), vec.end(), 7)-vec.begin();
    //���������е�һ�����ڱ�������ֵ
	pos2=upper_bound(vec.begin(), vec.end(), 7)-vec.begin();  
	cout<<pos1<<" "<<vec[pos1]<<endl;
	cout<<pos2<<" "<<vec[pos2]<<endl;

	return 0;
}