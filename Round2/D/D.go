package main

import (
    "bufio"
    "fmt"
    "math/rand"
    "os"
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

type Node struct {
    l, r *Node
    rank int
    key, add int
}

func (u *Node) Push() {
    if u.l != nil {
        u.l.key += u.add;
        u.l.add += u.add;
    }
    if u.r != nil {
        u.r.key += u.add;
        u.r.add += u.add;
    }
    u.add = 0;
}

func (u *Node) Size() int {
    if u == nil {
        return 0
    }
    return u.l.Size() + 1 + u.r.Size()
}

func (u *Node) Split(key int) (*Node, *Node) {
    if u == nil {
        return nil, nil
    }
    u.Push()
    if u.key < key {
        l, r := u.r.Split(key)
        u.r = l
        return u, r
    } else {
        l, r := u.l.Split(key)
        u.l = r
        return l, u
    }
}

func (u *Node) SplitLeft() (*Node, *Node) {
    if u == nil {
        return nil, nil
    }
    if u.l == nil {
        r := u.r
        u.r = nil
        return u, r
    }
    p := u
    for ; p.l.l != nil; p = p.l {
    }
    l := p.l
    r := l.r
    p.l = r
    return l, u
}

func Merge(u, v *Node) *Node {
    if u == nil {
        return v
    }
    if v == nil {
        return u
    }
    u.Push()
    v.Push()
    if u.rank > v.rank {
        u.r = Merge(u.r, v)
        return u
    } else {
        v.l = Merge(u, v.l)
        return v
    }
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    T := ReadInt(reader)
    for casi := int(0); casi < T; casi++ {
        n := ReadInt(reader)
        var rt *Node
        for i := 0; i < n; i++ {
            nums := ReadArray(reader)
            l, r := nums[0], nums[1]
            head, t1 := rt.Split(l)
            cover, t2 := t1.Split(r)
            _, tail := t2.SplitLeft()
            if cover != nil {
                cover.key += 1
                cover.add += 1
            }
            new_node := &Node{nil, nil, rand.Int(), l, 0}
            rt = Merge(head, Merge(new_node, Merge(cover, tail)))
        }
        fmt.Println(rt.Size())
    }
}
