#include <bits/stdc++.h>
using namespace std;

pair<int, int> a[100001];
int N, cnt;
int minh[100001]; // ��ͨ����y����Сֵ
int maxh[100001]; // ��ͨ����y�����ֵ
int main()
{
	// freopen("moop.in", "r", stdin);
	// freopen("moop.out", "w", stdout);
	scanf("%d", &N);
	for (int i = 1; i <= N; i++)
		scanf("%d%d", &a[i].first, &a[i].second);

	// �����е㰴�����������ÿ����ͨ�鶼��һ������������
	sort(a + 1, a + N + 1); // ���first��ȣ��ж�second

	for (int i = 1; i <= N; i++)
	{
		cnt++; // ��ͨ������1
		minh[cnt] = a[i].second;
		maxh[cnt] = a[i].second;
		// ��Ϊ���һ����ͨ����ֻҪ��һ����ȵ����ڶ�����ͨ���е�һ����x,yֵ����������ͨ����ܺϲ���
		// ��ͨ������� > 1 && ���ұߵ�������ͨ���У����1����ͨ����y�����ֵ >= ������2����y����Сֵ
		while (cnt > 1 && maxh[cnt] >= minh[cnt - 1])
		{
			// �����ұߵ�������ͨ��ϲ���һ��
			minh[cnt - 1] = min(minh[cnt - 1], minh[cnt]);  // ��ͨ����y����Сֵ
			maxh[cnt - 1] = max(maxh[cnt - 1], maxh[cnt]);  // ��ͨ����y�����ֵ
			cnt--;
		}
	}
	printf("%d\n", cnt);
	return 0;
}
