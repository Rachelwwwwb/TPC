package main

import (
    "bufio"
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

type IntHeap []int64

func (h IntHeap) Len() int { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x interface{}) { *h = append(*h, x.(int64)) }

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    T := ReadInt(reader)
    for casi := 0; casi < T; casi++ {
        n := ReadInt(reader)
        a := ReadArray(reader)

        lst := make(map[int]int)
        for i := 0; i < n; i++ {
            v, in := lst[a[i]]
            if !in {
                lst[a[i]] = 1
            } else {
                lst[a[i]] = v + 1
            }
        }
        a2 := make([]int64, 0)
        for k, v := range lst {
            t := int64(v) << 32 | int64(k)
            a2 = append(a2, t)
        }
        sort.Slice(a2, func(i, j int) bool {
            return a2[i] < a2[j]
        })
        m := len(a2)
        if (n - int(a2[m - 1] >> 32)) * 4 + 1 < n {
            fmt.Println("No")
            continue
        }

        lch := make([]int, n + 1)
        rch := make([]int, n + 1)
        val := make([]int, n + 1)
        for i := 1; i <= n; i++ {
            lch[i] = 0
            rch[i] = 0
        }
        mask := (int64(1) << 32) - 1
        val[1] = int(a2[m - 1] & mask)
        a2[m - 1] -= mask + 1
        A := make([]int, 0)
        B := make([]int, 0)
        sort.Slice(a2, func(i, j int) bool {
            return a2[i] < a2[j]
        })

        if int(a2[m - 1] >> 32) >= n / 2 {
            for i := m - 1; i < m; i++ {
                k := int(a2[i] & mask)
                c := int(a2[i] >> 32)
                for j := 0; j < c; j++ {
                    A = append(A, k)
                }
            }
            for i := 0; i < m - 1; i++ {
                k := int(a2[i] & mask)
                c := int(a2[i] >> 32)
                for j := 0; j < c; j++ {
                    B = append(B, k)
                }
            }
        } else {
            cur := 0
            s := 0
            limit := 3 * (n - 1) / 4
            for i := 0; i < m; i++ {
                s += int(a2[i] >> 32)
                if s <= limit && (n - 1 - s) <= limit {
                    cur = i + 1
                    break
                }
            }
            for i := cur; i < m; i++ {
                k := int(a2[i] & mask)
                c := int(a2[i] >> 32)
                for j := 0; j < c; j++ {
                    A = append(A, k)
                }
            }
            for i := 0; i < cur; i++ {
                k := int(a2[i] & mask)
                c := int(a2[i] >> 32)
                for j := 0; j < c; j++ {
                    B = append(B, k)
                }
            }
            if len(A) < len(B) {
                A, B = B, A
            }
        }

        h := &IntHeap{int64(1)}

        m = 2
        for len(A) > 0 && len(B) > 0 {
            tval := heap.Pop(h).(int64)
            dep := int(tval >> 32)
            u := int(tval & mask)
            if len(A) - 2 >= len(B) {
                lch[u] = m
                rch[u] = m + 1
                lch[m + 1] = m + 2
                rch[m + 1] = m + 3
                val[m] = A[0]
                val[m + 1] = B[0]
                val[m + 2] = A[1]
                val[m + 3] = A[2]
                heap.Push(h, int64(dep + 1) << 32 | int64(m))
                heap.Push(h, int64(dep + 2) << 32 | int64(m + 2))
                heap.Push(h, int64(dep + 2) << 32 | int64(m + 3))
                A = A[3: ]
                B = B[1: ]
                m += 4
            } else {
                lch[u] = m
                rch[u] = m + 1
                val[m] = A[0]
                val[m + 1] = B[0]
                heap.Push(h, int64(dep + 1) << 32 | int64(m))
                heap.Push(h, int64(dep + 1) << 32 | int64(m + 1))
                A = A[1: ]
                B = B[1: ]
                m += 2
            }
        }
        last := 0
        if len(A) > 0 {
            last = A[0]
        }
        if len(B) > 0 {
            last = B[0]
        }
        if last > 0 {
            for len(*h) > 0 {
                tval := heap.Pop(h).(int64)
                u := int(tval & mask)
                if val[u] != last {
                    lch[u] = n
                    val[n] = last
                    break
                }
            }
        }
        fmt.Println("Yes")
        for i := 1; i <= n; i++ {
            if lch[i] > 0 && val[lch[i]] < val[i] {
                lch[i], rch[i] = rch[i], lch[i]
            }
            if rch[i] > 0 && val[rch[i]] > val[i] {
                lch[i], rch[i] = rch[i], lch[i]
            }
        }

        for i := 1; i <= n; i++ {
            fmt.Println(val[i], lch[i], rch[i])
        }
    }
}
