ipackage main

import (
    "bufio"
    "fmt"
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

func main() {
    reader := bufio.NewReader(os.Stdin)
    T := ReadInt(reader)
    for casi := int(0); casi < T; casi++ {
        s := ReadLine(reader)
        a := strings.Count(s, "0")
        b := len(s) - a
        if b * 2 + 2 < a {
            fmt.Println("Impossible")
        } else if a == 0 {
            fmt.Println(s)
        } else {
            t := (a - 1) / 2
            fmt.Println(strings.Repeat("1", b - t) + strings.Repeat("001", t) +
                strings.Repeat("0", a - 2 * t))
        }
    }
}
