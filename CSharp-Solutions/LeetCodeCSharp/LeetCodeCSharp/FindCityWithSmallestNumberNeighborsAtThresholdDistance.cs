namespace LeetCodeCSharp
{
    public class FindCityWithSmallestNumberNeighborsAtThresholdDistance
    {
        public int FindTheCity(int n, int[][] edges, int distanceThreshold)
        {
            Dictionary<int,List<int>> cities = new Dictionary<int,List<int>>();
            Array.Sort(edges, (a, b) => a[0].CompareTo(b[0]));

            for (int i = 0; i < edges.Length; i++)
            {
                if (cities.Count == 0 || !cities.ContainsKey(edges[i][0]))
                {
                    cities.Add(edges[i][0], new List<int>());
                }
                if(edges[i][2] <= distanceThreshold) 
                {
                    cities[edges[i][0]].Add(i);
                }
            }

            int city = 0;
            int minNeighbors = int.MaxValue;
            foreach (var cityPair in cities)
            {
                if (cityPair.Value.Count < minNeighbors)
                {
                    city = cityPair.Key;
                    minNeighbors = cityPair.Value.Count;
                } else if (cityPair.Value.Count == minNeighbors && cityPair.Key > city)
                {
                    city = cityPair.Key;
                }
            }


            return city;
        }
    }
}