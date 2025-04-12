// swift-tools-version:5.7
import PackageDescription

let package = Package(
    name: "POCLib",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "POCLib",
            targets: ["POCLib"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "POCLib",
            url: "https://github.com/kneeman/POCLib/releases/download/v0.1.0/POCLib.xcframework.zip",
            checksum:"686f501bd466370230375a138873f493d5eaead79dcfa26629dfc380c97bb2ad"
        )
    ]
)