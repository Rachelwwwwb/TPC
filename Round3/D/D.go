ipackage main

import (
    "bufio"
    "bytes"
    "container/heap"
    "fmt"
    "os"
    "sort"
    "strconv"
    "strings"
)

func ReadLine(reader *bufio.Reader) string {
    line, _ := reader.ReadString('\n')
    return strings.TrimRight(line, "\n")
}

func ReadInt(reader *bufio.Reader) int {
    num, _ := strconv.Atoi(ReadLine(reader))
    return num
}

func ReadArray(reader *bufio.Reader) []int {
    line := ReadLine(reader);
    strs := strings.Split(line, " ")
    nums := make([]int, len(strs))
    for i, s := range strs {
        nums[i], _ = strconv.Atoi(s)
    }
    return nums
}

const N = 100000 + 10
var n int
var E, F [N][]int
var vis [N]int
var ans = make([]int, 0, N)

func DFS(u int) {
    vis[u] = 1
    sort.Ints(E[u])
    for i := len(E[u]) - 1; i >= 0; i-- {
        v := E[u][i]
        if vis[v] == 1 {
            continue
        }
        F[u] = append(F[u], v)
        DFS(v)
    }
}

type IntHeap []int

func (h IntHeap) Len() int { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x interface{}) { *h = append(*h, x.(int)) }

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
func BFS(u int) {
    h := &IntHeap{u}
    heap.Init(h)
    ans = ans[: 0]

    for h.Len() > 0 {
        u = heap.Pop(h).(int)
        ans = append(ans, u)
        for i := 0; i < len(F[u]); i++ {
            heap.Push(h, F[u][i])
        }
    }
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    T := ReadInt(reader)
    for casi := 0; casi < T; casi++ {
        s := ReadArray(reader)
        n = s[0]
        m := s[1]
        for i := 1; i <= n; i++ {
            E[i] = E[i][: 0]
            F[i] = F[i][: 0]
            vis[i] = 0
        }
        for i := 0; i < m; i++ {
            s = ReadArray(reader)
            u, v := s[0], s[1]
            E[u] = append(E[u], v)
            E[v] = append(E[v], u)
        }
        DFS(1)
        BFS(1)
        var buffer bytes.Buffer
        for i := 0; i < n; i++ {
            buffer.WriteString(strconv.Itoa(ans[i]))
            if i + 1 < n {
                buffer.WriteString(" ")
            }
        }
        fmt.Println(buffer.String())
    }
}
