num <- scan("stdin", what = integer(), quiet = TRUE)       
cas <- num[1]
ans <- integer(cas)
for (i in 1:cas) {
    if (num[i + 1] == 1) {
        ans[i] = 1
    } else {
        ans[i] = num[i + 1] %/% 2
    }
}
write(as.integer(ans), file = "", sep = "\n")
