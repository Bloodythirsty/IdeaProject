local current = redis.call('get',KEYS[1])
if current == ARGV[1]
    then redis.call('set',KEYS[1],ARGV[2])
    return true
end
return false