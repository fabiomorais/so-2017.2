import subprocess


a = 1
for i in range(1, 200000):
        a = i * a


subprocess.call(["sleep", "20"])

print "ok"

a = 1
for i in range(1, 200000):
        a = i * a

