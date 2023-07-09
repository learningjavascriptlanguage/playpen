#include <bits/stdc++.h>
using namespace std;

int sv[1024];
int sv_cnt;
int ans[32];
int ans_cnt;
char str[32][128];
bool find_same(int scene)
{
	for (int i = 0; i < 1024; i++) {
		if (sv[i] == scene)
		{
			return true;
		}
	}
	return false;
}

//三个杯子 abc  a的容量是3 b的容量是7 c的容量是10
void solve(int a, int b, int c)
{
	int cup[3] = { a,b,c };
	int v[3] = { 3,7,10 };
	int r1, r2;
	if ((b == 5 && c == 5)) {
		int t1, t2, t3;
		for (int i = 0; i < ans_cnt; i++) {
			printf("%s", str[i]);
			//printf("%03x \n", ans[i]);
			t1 = ans[i] / 16 / 16;
			t2 = ans[i] / 16 % 16;
			t3 = ans[i] % 16;
			for (int j = 10; j > 0; j--) {
				if (j <= t1) printf("■  ");
				else if (j <= 3) printf("□  ");
				else printf("    ");

				if (j <= t2) printf("■  ");
				else if (j <= 7) printf("□  ");
				else printf("    ");
				if (j <= t3) printf("■  ");
				else  printf("□  ");
				printf("\n");
			}

		}
		return;
	}

	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++) {
			//不能自己倒给自己 而且当自己的杯子没水的时候也不能倒
			if (i == j || cup[i] <= 0)continue;
			r1 = v[j] - cup[j]; //第j个杯子还可以倒r1升水
			//如果第i个杯子大于r1升水 就倒掉r1升水
			if (cup[i] >= r1) {
				cup[i] -= r1;
				cup[j] += r1;
				printf(str[ans_cnt], "将容积为%dL杯子中的%d升水倒入容积为%dL杯子中\n", v[i], r1, v[j]);
			}
			else {//如果没有就倒掉全部
				cup[j] += cup[i];

				printf(str[ans_cnt], "将容积为%dL杯子中的%d升水倒入容积为%dL杯子中\n", v[i], cup[i], v[j]);
				cup[i] = 0;
			}

			//如果当前的情况没有出现过就进行递归
			if (!find_same(cup[0] * 16 * 16 + cup[1] * 16 + cup[2]))
			{
				//记录一下这个情况
				sv[sv_cnt++] = cup[0] * 16 * 16 + cup[1] * 16 + cup[2];
				ans[ans_cnt++] = cup[0] * 16 * 16 + cup[1] * 16 + cup[2];
				solve(cup[0], cup[1], cup[2]);
				ans_cnt--;
			}
			//回溯
			cup[0] = a;
			cup[1] = b;
			cup[2] = c;

		}
	}
}

int main()
{
	solve(0, 0, 10);
	
	return 0;
}
