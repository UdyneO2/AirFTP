#pragma once
#include <string>
#include <vector>

namespace qr {
std::vector<std::vector<bool>> encode(const std::string& text);
}
