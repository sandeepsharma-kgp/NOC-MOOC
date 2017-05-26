#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define mp make_pair
#define pb push_back
#define ff first
#define ss second
#define present(m,v) (m.find(v)!=m.end())
#define INF 1e18
#define mod 1000000007
#define lim 1000001
#define sz(a) int(a.size())
#define all(x) (x).begin(), (x).end()
#define rep(i,n) for(i=0;i<n;i++)
#define forn(i,a,b) for(i=a;i<b;i++)

ll minDistance(ll dist[], bool sptSet[], ll V)
{
   ll min = INF, min_index;

   for (ll v = 0; v < V; v++)
     if (sptSet[v] == false && dist[v] <= min)
         min = dist[v], min_index = v;

   return min_index;
}


ll dijkstra(vector<vector<pair<ll,ll> > > &graph, ll V, ll src, ll fb)
{
     ll dist[V];
     bool sptSet[V];
     for (ll i = 0; i < V; i++)
        dist[i] = INF, sptSet[i] = false;
     dist[src] = 0;
     for (ll count = 0; count < V-1; count++)
     {
       ll u = minDistance(dist, sptSet, V);
       sptSet[u] = true;
       for (ll i=0;i<graph[u].size();i++)
       {
         pair<ll,ll> v=graph[u][i];
        if (!sptSet[v.ff] && dist[u] != INF && dist[u]+v.ss < dist[v.ff])
            dist[v.ff] = dist[u] + v.ss;
       }
     }
     return dist[fb];
}



int main()
{
    ll n,n1,fa,a,fb,b,i,w,cnt=0;
    cin>>n>>fa>>fb;
    n1=n;
	vector<vector<pair<ll,ll> > > adj(2010);
	while(n1--)
    {
        scanf("%lld%lld%lld",&a,&w,&b);
      cnt=max(max(a-1,b-1),cnt);
        adj[a-1].pb(mp(b-1,w));
        adj[b-1].pb(mp(a-1,w));
    }
  cnt=max(cnt,max(fa-1,fb-1));
    ll var=dijkstra(adj,cnt,fa-1,fb-1);
    if(var==INF)
        cout<<"NO";
    else cout<<"YES\n"<<var;
	return 0;
}
